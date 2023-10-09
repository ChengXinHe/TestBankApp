package com.learning.Entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;



@Entity
@Table(name = "approver")
public class ApproverEntity extends UserEntity{


    Boolean status;

    @OneToMany(mappedBy = "approver", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<StaffEntity> staffList;

    public ApproverEntity() {
    }

    public ApproverEntity(String approverusername, String approverfullname, String approverpassword) {
        super(approverusername,approverfullname,approverpassword);
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<StaffEntity> getStaffList() {
        return staffList;
    }


    public void setStaffList(List<StaffEntity> staffList) {
        this.staffList = staffList;
    }


    @Override
    public String toString() {
        return "ApproverEntity{" +
                "approverid=" + super.getId() +
                ", approvername='" + super.getFullname() + '\'' +
                ", approverusername='" + super.getUsername() + '\'' +
                ", approverpassword='" + super.getPassword() + '\'' +
                '}';
    }
}
