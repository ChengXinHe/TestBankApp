package com.learning.Controllers.v1;

import com.learning.Entity.DTO.ChangeStatusDTO;
import com.learning.Entity.model.ApproverEntity;
import com.learning.apis.staff.StaffClient;
import com.learning.common.DTO.ResponseResult;
import com.learning.Entity.DTO.StaffDTO;
import com.learning.service.ApproverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/admin")
public class ApproverController {

    @Autowired
    private ApproverService approverService;

    @Autowired
    private StaffClient staffClient;



    @GetMapping("/find/{approverId}")
    public ResponseResult findApproverById(@PathVariable Integer approverId) {
        Optional<ApproverEntity> approver = approverService.findApprover(approverId);
        return ResponseResult.okResult(approver);
    }


    @PostMapping("/staff")
    public ResponseResult createStaff(@RequestBody StaffDTO dto) {
        staffClient.createStaff(dto);
        //if success
        return ResponseResult.okResult("");
    }


    @GetMapping("/staff/{approverId}")
    public ResponseResult viewStaff(@PathVariable Integer approverId) {

        ResponseResult responseResult = staffClient.viewStaff(approverId);
        System.out.println(responseResult.getData());
        //if success
        return ResponseResult.okResult(responseResult.getData());
    }

    @PutMapping("/staff")
    public ResponseResult changeStatus(@RequestBody ChangeStatusDTO dto) {
        //if success
        System.out.println("Approver status change called");
        System.out.println(dto.getStaffid());
        System.out.println(dto.getStatus());
        return ResponseResult.okResult(staffClient.changeStatus(dto).getData());
    }
}

