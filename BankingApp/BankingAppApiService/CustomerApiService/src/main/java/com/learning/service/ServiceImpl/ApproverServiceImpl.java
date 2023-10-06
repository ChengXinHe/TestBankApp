package com.learning.service.ServiceImpl;


import com.learning.common.DTO.ResponseResult;
import com.learning.common.constants.AppHttpCodeEnum;
import com.learning.Entity.DTO.StaffDTO;
import org.springframework.stereotype.Service;

@Service
public class ApproverServiceImpl  {


    public ResponseResult createStaff(StaffDTO staffDTO) {
        if (true) {
            return ResponseResult.okResult(staffDTO);
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST, "staff already exit");
        }
    }


    public ResponseResult viewStaff(Integer adminId) {
        return ResponseResult.okResult("staffDTO");

    }


    public void enableAndDisable() {

    }
}
