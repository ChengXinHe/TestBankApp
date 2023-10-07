package com.learning.service;

import com.learning.Entity.model.StaffEntity;

import java.util.List;
import java.util.Optional;

public interface StaffService {

    public List<StaffEntity> viewStaff(Integer approverId);

    public void createStaff(StaffEntity staff);

    public void changeStatus(Integer staffId, boolean status);
}
