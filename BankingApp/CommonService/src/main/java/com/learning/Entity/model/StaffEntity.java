package com.learning.Entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffid;

    private String staffname;

    private Integer staffage;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "approverid")
    @JsonIgnore
    private ApproverEntity approver;

    public ApproverEntity getApprover() {
        return approver;
    }

    public void setApprover(ApproverEntity approver) {
        this.approver = approver;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public void setStaffage(Integer staffage) {
        this.staffage = staffage;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStaffname() {
        return staffname;
    }

    public Integer getStaffage() {
        return staffage;
    }


    @Override
    public String toString() {
        return "StaffEntity{" +
                "staffid=" + staffid +
                ", staffname='" + staffname + '\'' +
                ", staffage=" + staffage +
                ", status=" + status +
                '}';
    }
}
