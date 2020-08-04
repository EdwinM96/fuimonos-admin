/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fuimonosapp.service;

import com.fuimonosapp.domain.*;
import com.fuimonosapp.repository.DriverRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP PC
 */
@Service
public class DriverService {
    
    @Autowired
    DriverRepository dr;
    
    private int PAGESIZE = 10;
    
    public Page<Driver> findAllWithSearchWord(Integer page, String searchWord){
        
        return dr.findAllByUsernameContainsOrderByDriverId(searchWord, PageRequest.of(page, PAGESIZE));
    }
    
    public Driver save(Driver driver){
        driver.setFechaCreado(Calendar.getInstance().getTime());
        driver.setHabilitado(true);
        return dr.save(driver);
    }

    public Page<Driver> findAll(Integer page) {
        return dr.findAll(PageRequest.of(page, PAGESIZE));
    }

    public Driver findById(Integer driverId) {
        return dr.findById(driverId).get();
    }

    public Driver update(Driver driver) {
        return dr.save(driver);
    }

    public List<Driver> findAll() {
        return dr.findAll();
    }
    
    
}
