/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.web;

import com.internproject.euphoria.euphoria.model.TimesheetData;
import com.internproject.euphoria.euphoria.repository.TimesheetDataRepository;
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
@RequestMapping("/api/TimesheetData")
public class TimesheetDataController {
    @Autowired
    TimesheetDataRepository repository;
    
    @RequestMapping(method = GET)
    public List<TimesheetData> getTimesheetData() {
        return (List<TimesheetData>) repository.findAll();
    }
    
    @RequestMapping(method = GET, value = "/{id}")
    public TimesheetData getTimesheetDataById(@PathVariable String id) {
        Optional<TimesheetData> TimesheetData = repository.findById(id);
        try {
            return TimesheetData.get();
        } catch (Exception ex) {
            throw new RuntimeException("User Profile not found:" + ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = POST)
    public ResponseEntity addTimesheetData(@RequestBody TimesheetData TimesheetData) {
        try {
            repository.save(TimesheetData);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = PUT, value = "/{id}")
    public ResponseEntity updateProfileUser(@PathVariable String id, @RequestBody TimesheetData TimesheetData) {
        try {
            TimesheetData.setId(id);
            repository.save(TimesheetData);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public void deleteTimesheetData(@PathVariable String id) {
        Optional<TimesheetData> TimesheetData = repository.findById(id);
        try {
            repository.delete(TimesheetData.get());
        } catch (Exception ex) {
            throw new RuntimeException("Delete TimesheetData failed:" + ex.getLocalizedMessage());
        }
    }
}
