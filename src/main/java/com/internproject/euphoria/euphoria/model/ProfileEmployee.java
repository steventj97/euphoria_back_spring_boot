/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author stevetj
 */
@Data 
@Entity
public class ProfileEmployee {
    @Id
    private String id;
    private String employeeName;
    private String indentityNo;
    private String address;
    private String posCode;
    private String contactNumber;
    private String email;
    private String birthPlace;
    private String gender;
    private String married_status;
    private String ethnics;
    private String religion;
    private String language;
    private String spouseName;
    private Integer numberOfChildren;
    private String resignReason;
    private String pasPhoto;
    @ManyToOne
    @JoinColumn(name="department_category_id", referencedColumnName="id")
    private DepartmentCategory departmentCategory;
    @ManyToOne
    @JoinColumn(name="position_category_id", referencedColumnName="id")
    private PositionCategory positionCategory;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_timesheetData", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "timesheet_data_id", referencedColumnName = "id"))
    private List<TimesheetData> timesheetdatas;
    
}

