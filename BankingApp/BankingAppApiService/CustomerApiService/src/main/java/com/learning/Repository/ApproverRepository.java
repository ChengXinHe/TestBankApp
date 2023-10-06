package com.learning.Repository;

import com.learning.Utils.jwt.Admin.ApproverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproverRepository extends JpaRepository<ApproverEntity, Integer> {
}
