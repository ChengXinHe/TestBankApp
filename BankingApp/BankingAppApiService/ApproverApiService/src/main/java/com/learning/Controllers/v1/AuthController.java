package com.learning.Controllers.v1;

import com.learning.Entity.DTO.JwtResponse;
import com.learning.Entity.DTO.LoginRequest;
import com.learning.Entity.DTO.SignupRequest;
import com.learning.Entity.model.ApproverEntity;
import com.learning.Entity.model.Role;
import com.learning.Repository.ApproverRepository;
import com.learning.Repository.RoleRepository;
import com.learning.Repository.UserRepository;
import com.learning.Utils.jwt.JwtUtils;
import com.learning.common.DTO.ResponseResult;
import com.learning.common.constants.Roles;
import com.learning.service.ServiceImpl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth/admin")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApproverRepository approverRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseResult<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        System.out.println("JWT Token="+jwt);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseResult.okResult(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }



    @PostMapping("/signup")
    public ResponseResult registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseResult.errorResult(1002,"Error: Username is already taken!");
        }

        System.out.println(signUpRequest.getFullname());
        System.out.println(signUpRequest.getUsername());
        System.out.println(signUpRequest.getPassword());

        // Create new user's account
        ApproverEntity user = new ApproverEntity(signUpRequest.getUsername(),
                signUpRequest.getFullname(),
                encoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role adminRole = roleRepository.findByName(Roles.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);


        Role modRole = roleRepository.findByName(Roles.ROLE_STAFF)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(modRole);

        Role userRole = roleRepository.findByName(Roles.ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);


        approverRepository.save(user);

        return ResponseResult.okResult("User registered successfully!");
    }
}
