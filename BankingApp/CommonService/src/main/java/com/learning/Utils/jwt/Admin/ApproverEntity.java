package com.learning.Utils.jwt.Admin;

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
    Roles role = Roles.ROLE_ADMIN; //select from Roles enum

    @NotBlank
    String status;

    @OneToMany(mappedBy = "approver", fetch = FetchType.LAZY)
    private List<StaffEntity> staffList;
}
