package com.ris.pause_together.controllers;

import com.ris.pause_together.dao.VsebinaRepository;
import com.ris.pause_together.models.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vsebine")
public class VsebinaController {

    @Autowired
    private VsebinaRepository vsebinaDao; //repository


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping
    public Iterable<Vsebina> vrniVsebine(){
        return vsebinaDao.findAll();
    }

    @PostMapping
    public Vsebina dodajVsebine(@RequestBody Vsebina vsebina){
        return vsebinaDao.save(vsebina);
    }
}
