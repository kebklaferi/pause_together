package com.ris.pause_together.controllers;

import com.ris.pause_together.dao.SeznamRepository;
import com.ris.pause_together.models.Seznam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seznami")
public class SeznamController {
    @Autowired
    private SeznamRepository seznamdao;

    @PostMapping
    public Seznam dodajSeznam(@RequestBody Seznam sez){
        return seznamdao.save(sez);
    }
}
