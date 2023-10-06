package com.learning.service;

import com.learning.common.DTO.ResponseResult;
import com.learning.Entity.DTO.StaffDTO;

public interface ApproverService {
    public ResponseResult createStaff(StaffDTO staffDTO);
    public ResponseResult viewStaff(Integer adminId);

    public void enableAndDisable();
}
