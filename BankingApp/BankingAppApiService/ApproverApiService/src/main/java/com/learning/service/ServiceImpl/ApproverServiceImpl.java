package com.learning.service.ServiceImpl;

import com.learning.Repository.ApproverRepository;
import com.learning.Utils.jwt.Admin.ApproverEntity;
import com.learning.common.DTO.ResponseResult;
import com.learning.common.constants.AppHttpCodeEnum;
import com.learning.Entity.DTO.StaffDTO;
import com.learning.service.ApproverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproverServiceImpl implements ApproverService {

    @Autowired
    ApproverRepository approverRepository;
    @Override
    public ResponseResult createStaff(StaffDTO staffDTO) {
        if (true) {
            return ResponseResult.okResult(staffDTO);
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST, "staff already exit");
        }
    }

    @Override
    public ResponseResult viewStaff(Integer adminId) {
        List<ApproverEntity> approvers = approverRepository.findAll();

        if (approvers.isEmpty()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        } else {
            return ResponseResult.okResult(approvers);
        }

    }

    @Override
    public void enableAndDisable() {

    }
}
