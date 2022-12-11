package com.ris.pause_together.controllers;

import com.ris.pause_together.dao.ProfilRepository;
import com.ris.pause_together.models.Profil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profili")
public class ProfilController {
    @Autowired
    private ProfilRepository profildao;


    //implementacija zapisa get za vse profile
    @GetMapping
    public Iterable<Profil> vrniVseProfile(){
        return profildao.findAll();
    }

    //implementacija zapisa po id
    @GetMapping("/profil/{id}")
    public Iterable<Profil> vrniProfilPoId(@PathVariable("id") int id){
        return profildao.vrniPoId(id);
    }
    //dodajanje zapisa
    @PostMapping
    public Profil dodajProfil(@RequestBody Profil profil){
        return profildao.save(profil);
    }
}
