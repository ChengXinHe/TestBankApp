package com.learning.service.ServiceImpl;

import com.learning.Repository.ApproverRepository;
import com.learning.Entity.model.ApproverEntity;
import com.learning.common.DTO.ResponseResult;
import com.learning.common.constants.AppHttpCodeEnum;
import com.learning.Entity.DTO.StaffDTO;
import com.learning.service.ApproverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApproverServiceImpl implements ApproverService {

    @Autowired
    ApproverRepository approverRepository;

    @Override
    public Optional<ApproverEntity> findApprover(Long approverId) {
        Optional<ApproverEntity> approver = approverRepository.findById(approverId);
        return approver;
    }

    @Override
    public ResponseResult createStaff(StaffDTO staffDTO) {
        if (true) {
            return ResponseResult.okResult(staffDTO);
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST, "staff already exit");
        }
    }

    @Override
    public Optional<ApproverEntity> viewStaff(Long  approverId) {
        Optional<ApproverEntity> approvers = approverRepository.findById(approverId);

        return approvers;

    }

    @Override
    public void enableAndDisable() {

    }
}
