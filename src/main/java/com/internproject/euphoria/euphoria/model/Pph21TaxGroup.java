/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author stevetj
 */
@Entity
@Data
public class Pph21TaxGroup {
    @Id
    private String id;
    private String taxRegulation;
    private Long pkp;
    private Long ptkp;
    private Boolean marriageStatus;
    private Integer tanggungan;
    private Boolean hasNpwp;
    private String workingStatus;
    private Long percentReduction;
}
