package com.learning.Entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.common.constants.Roles;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "approver",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "approvername"),
        })
public class ApproverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer approverid;

    @NotBlank
    String approvername;

    @NotBlank
    Integer role = Roles.ROLE_ADMIN.getCode(); //select from Roles enum

    @NotBlank
    String status;

    @OneToMany(mappedBy = "approver", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<StaffEntity> staffList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StaffEntity> getStaffList() {
        return staffList;
    }

    public void setApproverid(Integer approverid) {
        this.approverid = approverid;
    }

    public void setApprovername(String approvername) {
        this.approvername = approvername;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public void setStaffList(List<StaffEntity> staffList) {
        this.staffList = staffList;
    }

    public Integer getApproverid() {
        return approverid;
    }

    public String getApprovername() {
        return approvername;
    }

    public Integer getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "ApproverEntity{" +
                "approverid=" + approverid +
                ", approvername='" + approvername + '\'' +
                ", role=" + role +
                ", status='" + status + '\'' +
                '}';
    }
}
