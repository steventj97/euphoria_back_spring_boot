/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.web;

import com.internproject.euphoria.euphoria.model.ProfileEmployee;
import com.internproject.euphoria.euphoria.repository.ProfileEmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kira Katou
 */
@CrossOrigin
@RestController
@RequestMapping("/api/ProfileEmployee")
public class ProfileEmployeeController {
    @Autowired
    ProfileEmployeeRepository repository;
    
    @RequestMapping(method = GET)
    public List<ProfileEmployee> getProfileEmployee() {
        return (List<ProfileEmployee>) repository.findAll();
    }
    
    @RequestMapping(method = GET, value = "/{id}")
    public ProfileEmployee getProfileEmployeeById(@PathVariable String id) {
        Optional<ProfileEmployee> ProfileEmployee = repository.findById(id);
        try {
            return ProfileEmployee.get();
        } catch (Exception ex) {
            throw new RuntimeException("User Profile not found:" + ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = POST)
    public ResponseEntity addProfileEmployee(@RequestBody ProfileEmployee ProfileEmployee) {
        try {
            repository.save(ProfileEmployee);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = PUT, value = "/{id}")
    public ResponseEntity updateProfileUser(@PathVariable String id, @RequestBody ProfileEmployee ProfileEmployee) {
        try {
            ProfileEmployee.setId(id);
            repository.save(ProfileEmployee);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public void deleteProfileEmployee(@PathVariable String id) {
        Optional<ProfileEmployee> ProfileEmployee = repository.findById(id);
        try {
            repository.delete(ProfileEmployee.get());
        } catch (Exception ex) {
            throw new RuntimeException("Delete ProfileEmployee failed:" + ex.getLocalizedMessage());
        }
    }
}
