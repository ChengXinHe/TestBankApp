package com.learning.Entity.DTO;

public class StaffDTO {
    Long approverid;
    String staffusername;

    String stafffullname;

    String password;


    public Long getApproverid() {
        return approverid;
    }

    public void setApproverid(Long approverid) {
        this.approverid = approverid;
    }

    public void setStaffusername(String staffusername) {
        this.staffusername = staffusername;
    }

    public void setStafffullname(String stafffullname) {
        this.stafffullname = stafffullname;
    }

    public String getStaffusername() {
        return staffusername;
    }

    public String getStafffullname() {
        return stafffullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
