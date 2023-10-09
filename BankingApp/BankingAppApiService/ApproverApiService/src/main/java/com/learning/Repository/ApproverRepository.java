package com.learning.Repository;


import com.learning.Entity.model.ApproverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApproverRepository extends JpaRepository<ApproverEntity, Long> {

}
