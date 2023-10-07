package com.learning.Controllers.v1;

import com.learning.Entity.DTO.ChangeStatusDTO;
import com.learning.Entity.model.ApproverEntity;
import com.learning.Entity.model.StaffEntity;
import com.learning.apis.approver.ApproverClient;
import com.learning.common.DTO.ResponseResult;
import com.learning.Entity.DTO.StaffDTO;
import com.learning.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;


    @PostMapping("/createstaff")
    public ResponseResult createStaff(@RequestBody StaffDTO dto) {
        System.out.println("create staff");
        StaffEntity staff = new StaffEntity();
        staff.setStaffage(dto.getStaffage());
        staff.setStaffname(dto.getStaffname());
        ApproverEntity approver = new ApproverEntity();
        approver.setApproverid(dto.getApproverid());
        staff.setStatus(!dto.getStatus());


        staff.setApprover(approver);
        //if success
        staffService.createStaff(staff);
        return ResponseResult.okResult("");
    }


    @GetMapping("/viewall/{approverId}")
    public ResponseResult viewStaff(@PathVariable Integer approverId) {
        List<StaffEntity> result = staffService.viewStaff(approverId);
        for (StaffEntity s : result) {
            System.out.println(s.toString());
        }
        return ResponseResult.okResult(result);
    }

    @PutMapping("/createstaff")
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

