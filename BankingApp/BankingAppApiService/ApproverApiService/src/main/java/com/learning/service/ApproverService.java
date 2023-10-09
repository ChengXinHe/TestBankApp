package com.learning.service;
import com.learning.Entity.model.ApproverEntity;
import com.learning.common.DTO.ResponseResult;
import com.learning.Entity.DTO.StaffDTO;

import java.util.Optional;

public interface ApproverService {
    public ResponseResult createStaff(StaffDTO staffDTO);
    public Optional<ApproverEntity> viewStaff(Long approverId);
    public Optional<ApproverEntity> findApprover(Long approverId);
    public void enableAndDisable();
}
