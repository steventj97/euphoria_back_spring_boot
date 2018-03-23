/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.model;

import java.util.List;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author stevetj
 */
@Data
@Entity
public class PayrollData {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="position_record_id", referencedColumnName="id")
    private PositionCategory position;
    @ManyToOne
    @JoinColumn(name="department_record_id", referencedColumnName="id")
    private DepartmentCategory department;
    private Long payrollPerHours;

}
