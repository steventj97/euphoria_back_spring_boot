/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.web;

import com.internproject.euphoria.euphoria.model.Pph21TaxGroup;
import com.internproject.euphoria.euphoria.repository.Pph21TaxGroupRepository;
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
@RequestMapping("/api/Pph21TaxGroup")
public class Pph21TaxGroupController {
    @Autowired
    Pph21TaxGroupRepository repository;
    
    @RequestMapping(method = GET)
    public List<Pph21TaxGroup> getPph21TaxGroup() {
        return (List<Pph21TaxGroup>) repository.findAll();
    }
    
    @RequestMapping(method = GET, value = "/{id}")
    public Pph21TaxGroup getPph21TaxGroupById(@PathVariable String id) {
        Optional<Pph21TaxGroup> Pph21TaxGroup = repository.findById(id);
        try {
            return Pph21TaxGroup.get();
        } catch (Exception ex) {
            throw new RuntimeException("User Profile not found:" + ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = POST)
    public ResponseEntity addPph21TaxGroup(@RequestBody Pph21TaxGroup Pph21TaxGroup) {
        try {
            repository.save(Pph21TaxGroup);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = PUT, value = "/{id}")
    public ResponseEntity updateProfileUser(@PathVariable String id, @RequestBody Pph21TaxGroup Pph21TaxGroup) {
        try {
            Pph21TaxGroup.setId(id);
            repository.save(Pph21TaxGroup);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public void deletePph21TaxGroup(@PathVariable String id) {
        Optional<Pph21TaxGroup> Pph21TaxGroup = repository.findById(id);
        try {
            repository.delete(Pph21TaxGroup.get());
        } catch (Exception ex) {
            throw new RuntimeException("Delete Pph21TaxGroup failed:" + ex.getLocalizedMessage());
        }
    }
}
