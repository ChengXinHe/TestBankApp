package com.learning.Entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "staff")
public class StaffEntity extends UserEntity{

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "approverid")
    @JsonIgnore
    private ApproverEntity approver;

    public StaffEntity() {
    }

    public StaffEntity(String staffusername,String stafffullname, String staffpassword) {
        super(staffusername,stafffullname,staffpassword);
    }

    public ApproverEntity getApprover() {
        return approver;
    }

    public void setApprover(ApproverEntity approver) {
        this.approver = approver;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "StaffEntity{" +
                "staffid=" + super.getId() +
                ", staffname='" + super.getFullname() + '\'' +
                ", staffusername='" + super.getUsername() + '\'' +
                ", staffpassword='" + super.getPassword() + '\'' +
                ", status=" + status +
                '}';
    }
}
