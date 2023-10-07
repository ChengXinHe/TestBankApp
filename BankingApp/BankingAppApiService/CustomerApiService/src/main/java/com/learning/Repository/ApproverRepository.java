package com.learning.Repository;

import com.learning.Entity.model.ApproverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproverRepository extends JpaRepository<ApproverEntity, Integer> {
}
