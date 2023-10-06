package com.learning.service.ServiceImpl;

import com.learning.common.DTO.ResponseResult;
import com.learning.Repository.StaffRepository;
import com.learning.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;

    @Override
    public ResponseResult viewStaff() {
        return ResponseResult.okResult("");
    }
}
