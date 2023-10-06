package com.learning.apis.approver;

import com.learning.common.DTO.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



@FeignClient(value = "approver-api-service")
public interface ApproverClient {

    @GetMapping("/viewall")
    public ResponseResult viewStaff(Integer adminId);

}
