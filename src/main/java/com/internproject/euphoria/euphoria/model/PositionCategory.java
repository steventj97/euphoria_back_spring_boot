/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author stevetj
 */
@Entity
@Data
public class PositionCategory {
    @Id
    public String id;
    public String positionName;
    private Integer positionNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "positionCategory")
    private List<ProfileEmployee> profile;
    @JsonIgnore
    @OneToMany(mappedBy = "position")
    private List<PayrollData> payroll;

}
