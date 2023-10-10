package com.learning.Controllers.v1;

import com.learning.Entity.DTO.ChangeStatusDTO;
import com.learning.Entity.DTO.SignupRequest;
import com.learning.Entity.model.ApproverEntity;
import com.learning.Entity.model.StaffEntity;
import com.learning.apis.approver.ApproverClient;
import com.learning.common.DTO.ResponseResult;
import com.learning.Entity.DTO.StaffDTO;
import com.learning.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private AuthController authController;


    @PostMapping("/createstaff")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseResult createStaff(@RequestBody StaffDTO dto) {
        ResponseResult result = authController.registerUser(dto);
        if (result.getCode().equals("200")) {
            return ResponseResult.okResult(result.getData());
        } else {
            return ResponseResult.errorResult(result.getCode(),result.getErrorMessage());
        }

    }


    @GetMapping("/viewall/{approverId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseResult viewStaff(@PathVariable Long approverId) {
        List<StaffEntity> result = staffService.viewStaff(approverId);
        for (StaffEntity s : result) {
            System.out.println(s.toString());
        }
        return ResponseResult.okResult(result);
    }

    @PutMapping("/createstaff")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseResult changeStatus(@RequestBody ChangeStatusDTO dto) {
         try {
             System.out.println(dto.getStaffid());
             System.out.println(dto.getStatus());
             staffService.changeStatus(dto.getStaffid(), dto.getStatus());
             return ResponseResult.okResult("success to update status");
         } catch (Exception e) {
             return ResponseResult.errorResult(500,"fail to update status"+ e.getMessage());
         }
    }
}

