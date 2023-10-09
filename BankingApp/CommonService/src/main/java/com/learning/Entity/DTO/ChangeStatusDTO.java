package com.learning.Entity.DTO;

public class ChangeStatusDTO {
    private Long staffid;
    private boolean status;

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
