/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.repository;

import com.internproject.euphoria.euphoria.model.ProfileEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Kira Katou
 */
public interface ProfileEmployeeRepository extends CrudRepository<ProfileEmployee,String>,PagingAndSortingRepository<ProfileEmployee,String>{
    
}
