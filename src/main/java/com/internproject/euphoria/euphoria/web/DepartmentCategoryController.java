/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.internproject.euphoria.euphoria.web;

import com.internproject.euphoria.euphoria.model.DepartmentCategory;
import com.internproject.euphoria.euphoria.repository.DepartmentCategoryRepository;
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
@RequestMapping("/api/DepartmentCategory")
public class DepartmentCategoryController {
    @Autowired
    DepartmentCategoryRepository repository;
    
    @RequestMapping(method = GET)
    public List<DepartmentCategory> getDepartmentCategory() {
        return (List<DepartmentCategory>) repository.findAll();
    }
    
    @RequestMapping(method = GET, value = "/{id}")
    public DepartmentCategory getDepartmentCategoryById(@PathVariable String id) {
        Optional<DepartmentCategory> DepartmentCategory = repository.findById(id);
        try {
            return DepartmentCategory.get();
        } catch (Exception ex) {
            throw new RuntimeException("User Profile not found:" + ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = POST)
    public ResponseEntity addDepartmentCategory(@RequestBody DepartmentCategory DepartmentCategory) {
        try {
            repository.save(DepartmentCategory);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = PUT, value = "/{id}")
    public ResponseEntity updateProfileUser(@PathVariable String id, @RequestBody DepartmentCategory DepartmentCategory) {
        try {
            DepartmentCategory.setId(id);
            repository.save(DepartmentCategory);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public void deleteDepartmentCategory(@PathVariable String id) {
        Optional<DepartmentCategory> DepartmentCategory = repository.findById(id);
        try {
            repository.delete(DepartmentCategory.get());
        } catch (Exception ex) {
            throw new RuntimeException("Delete DepartmentCategory failed:" + ex.getLocalizedMessage());
        }
    }
}
