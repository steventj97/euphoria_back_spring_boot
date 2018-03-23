/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.repository;

import com.internproject.euphoria.euphoria.model.TimesheetPeriod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Kira Katou
 */
public interface TimesheetPeriodRepository extends CrudRepository<TimesheetPeriod,String>,PagingAndSortingRepository<TimesheetPeriod,String>{
    
}
