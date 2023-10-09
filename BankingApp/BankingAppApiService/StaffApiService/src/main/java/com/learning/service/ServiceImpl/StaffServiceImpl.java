package com.learning.service.ServiceImpl;

import com.learning.Entity.model.StaffEntity;
import com.learning.Repository.StaffRepository;
import com.learning.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {


    @Autowired
    StaffRepository staffRepository;

    @Override
    public List<StaffEntity>  viewStaff(Long approverid) {
        List<StaffEntity> staffList = staffRepository.findByApprover_Id(approverid);
        return staffList;
    }

    @Override
    public void createStaff(StaffEntity staff) {
        staffRepository.save(staff);
    }

    @Override
    public void changeStatus(Long staffId, boolean status) {
        Optional<StaffEntity> optionalStaff = staffRepository.findById(staffId);
        if (optionalStaff.isPresent()) {
            StaffEntity staff = optionalStaff.get();
            staff.setStatus(!status);
            staffRepository.save(staff); // 更新staff的status
        }

    }
}
