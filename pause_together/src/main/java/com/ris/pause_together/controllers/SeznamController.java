package com.ris.pause_together.controllers;

import com.ris.pause_together.dao.SeznamRepository;
import com.ris.pause_together.models.Seznam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seznami")
public class SeznamController {
    @Autowired
    private SeznamRepository seznamdao;

    @PostMapping
    public Seznam dodajSeznam(@RequestBody Seznam sez){
        return seznamdao.save(sez);
    }

    @GetMapping
    public Iterable<Seznam> vrniVseSezname(){
        return seznamdao.findAll();
    }

    //seznam, ki ima vsaj eno pesem
    @GetMapping("/polni")
    public Iterable<Seznam> vrniPolneSezname(){
        return seznamdao.vrniPolneSezname();
    }
}
