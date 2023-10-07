package com.learning.apis.staff;

import com.learning.Entity.DTO.ChangeStatusDTO;
import com.learning.Entity.DTO.StaffDTO;
import com.learning.common.DTO.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "staff-api-service", url = "http://localhost:8083")
public interface StaffClient {

    @GetMapping("/api/v1/staff/viewall/{approverId}")
    public ResponseResult viewStaff(@PathVariable Integer approverId);

    @PostMapping("/api/v1/staff/createstaff")
    public ResponseResult createStaff(@RequestBody StaffDTO dto);

    @PutMapping("/api/v1/staff/createstaff")
    public ResponseResult changeStatus(@RequestBody ChangeStatusDTO dto);

}
