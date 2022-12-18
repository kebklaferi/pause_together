package com.ris.pause_together.controllers;

import com.ris.pause_together.dao.UporabnikRepository;
import com.ris.pause_together.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/uporabniki")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikdao;

    @GetMapping
    public Iterable<Uporabnik> vsiUporabniki(){
        return uporabnikdao.findAll();
    }

    @PostMapping
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik upo){
        System.out.println(upo);
        return uporabnikdao.save(upo);
    }

    @DeleteMapping("izbrisi/{id}")
    public void izbrisiUporabnika(@PathVariable("id") Long id){
      uporabnikdao.deleteById(id);
    }

}
