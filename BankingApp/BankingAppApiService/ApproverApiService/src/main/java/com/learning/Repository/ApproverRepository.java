package com.learning.BankingApp.Repository;


import com.learning.Entity.Admin.ApproverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproverRepository extends JpaRepository<ApproverEntity, Integer> {
}
