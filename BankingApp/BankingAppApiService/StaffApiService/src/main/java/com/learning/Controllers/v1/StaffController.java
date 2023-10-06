package com.learning.Controllers.v1;

import com.learning.common.DTO.ResponseResult;
import com.learning.Entity.DTO.StaffDTO;
import com.learning.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/admin")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/create")
    public ResponseResult createStaff(@RequestBody StaffDTO dto) {
        //if success
        return ResponseResult.okResult("");
    }


    @GetMapping("/viewall")
    public ResponseResult viewStaff(Integer adminId) {
        //if success
        return ResponseResult.okResult("");
    }
}

