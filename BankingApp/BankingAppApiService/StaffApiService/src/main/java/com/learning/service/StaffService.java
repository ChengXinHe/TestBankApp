package com.learning.service;

import com.learning.Entity.model.StaffEntity;
import java.util.List;

public interface StaffService {

    public List<StaffEntity> viewStaff(Long approverId);

    public void createStaff(StaffEntity staff);

    public void changeStatus(Long staffId, boolean status);
}
