package com.ris.pause_together.controllers;

import com.ris.pause_together.dao.VsebinaRepository;
import com.ris.pause_together.models.Vsebina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/vsebine")
public class VsebinaController {

    @Autowired
    private VsebinaRepository vsebinaDao; //repository
    
    @GetMapping
    public Iterable<Vsebina> vrniVsebine(){
        return vsebinaDao.findAll();
    }

    @PostMapping
    public Vsebina dodajVsebine(@RequestBody Vsebina vsebina){
        return vsebinaDao.save(vsebina);
    }

    // KLARA - poizvedba po podanem letu izdaje, ocena vecja od podane, tocno dolocen avtor
    @GetMapping("/param")
    public Iterable<Vsebina> vrniPoParametrih(@RequestParam("avtor") String avtor, @RequestParam("leto_i") Long leto, @RequestParam("ocena") Long ocena){
        return vsebinaDao.vrniPoParametrih(avtor, leto, ocena);
    }

}
