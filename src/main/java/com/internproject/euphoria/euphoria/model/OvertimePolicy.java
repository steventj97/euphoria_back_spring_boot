/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author steve
 */
@Entity
@Data
public class OvertimePolicy {
    @Id
    private String id;
    private String type;
    private Integer CompensationRate;
    private Integer Multiplier;
}
