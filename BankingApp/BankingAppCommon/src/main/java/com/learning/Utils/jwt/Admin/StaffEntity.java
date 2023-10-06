package com.learning.Utils.jwt.Admin;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffid;

    private String staffname;

    private Integer staffage;

    @ManyToOne
    @JoinColumn(name = "approver_id")
    private ApproverEntity approver;

}
