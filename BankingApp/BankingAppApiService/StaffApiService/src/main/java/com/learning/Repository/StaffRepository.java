package com.learning.Repository;

import com.learning.Utils.jwt.Admin.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {
    List<StaffEntity> findByApprover_Approverid(Integer approverId);

}