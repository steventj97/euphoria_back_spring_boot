/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
public class TimesheetData {
    @Id
    private String id;  
    @ManyToOne
    @JoinColumn(name="timesheet_period_id", referencedColumnName="id")
    private TimesheetPeriod period;
    @ManyToOne
    @JoinColumn(name="profile_employee_id", referencedColumnName="id")
    private ProfileEmployee employee;
    private double present;
    private double overtime;
    private double timeoff;
}
