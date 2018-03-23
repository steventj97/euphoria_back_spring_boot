/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author stevetj
 */
@Data
@Entity
public class OvertimeHistory {
    @Id
    private String id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date requestDate;
    @OneToOne
    @JoinColumn(name="employee_id" , referencedColumnName="id")
    private ProfileEmployee employee;
    @OneToOne
    @JoinColumn(name="overtime_policy_id" , referencedColumnName="id")
    private OvertimePolicy overtime;
    private Long overtimeHours;
    private String overtimeReason;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date supervisorApprovalDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date managerApprovalDate;
    private Long compensation;
}
