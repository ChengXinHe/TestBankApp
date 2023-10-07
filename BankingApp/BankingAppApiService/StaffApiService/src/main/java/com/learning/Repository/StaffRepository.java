package com.learning.Repository;

import com.learning.Entity.model.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {
    List<StaffEntity> findByApprover_Approverid(Integer approverId);

}