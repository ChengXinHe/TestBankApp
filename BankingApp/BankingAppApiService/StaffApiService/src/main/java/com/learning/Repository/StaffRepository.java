package com.learning.Repository;

import com.learning.Entity.model.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
    List<StaffEntity> findByApprover_Id(Long approverId);

}