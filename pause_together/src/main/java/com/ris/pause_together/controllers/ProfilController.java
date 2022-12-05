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

    @GetMapping
    public Iterable<Profil> vrniVseProfile(){
        return profildao.findAll();
    }

    @PostMapping
    public Profil dodajProfil(@RequestBody Profil profil){
        return profildao.save(profil);
    }
}
