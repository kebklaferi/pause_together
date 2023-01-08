package com.ris.pause_together.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.ris.pause_together.dao.ProfilRepository;
import com.ris.pause_together.models.Profil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/profili")
public class ProfilController {
    @Autowired
    private ProfilRepository profildao;
    ObjectMapper objectMapper = new ObjectMapper();



    //KLARA -implementacija zapisa get za vse profile
    @GetMapping
    public Iterable<Profil> vrniVseProfile(){
        return profildao.findAll();
    }

    //KLARA - implementacija zapisa po id
    @GetMapping("/profil/{id}")
    public Iterable<Profil> vrniProfilPoId(@PathVariable("id") int id){
        return profildao.vrniPoId(id);
    }

    //KLARA -dodajanje zapisa
    @PostMapping
    public Profil dodajProfil(@RequestBody Profil profil){
        return profildao.save(profil);
    }

    //KLARA - spreminjanje imena v profilu - update query
    @PutMapping("/spremeni/{id}")
    public int spremeniProfil(@RequestBody String jsonObjekt, @PathVariable("id") Integer id) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(jsonObjekt);
        String ime = jsonNode.get("ime").asText();
        System.out.println(ime);
        return profildao.spremeniProfil(ime, id);
    }
    //KLARA - izbris profila by id
    @DeleteMapping("izbrisi/{id}")
    public void izbrisiProfil(@PathVariable("id") Long id){
        profildao.deleteById(id);
    }

    //KLARA - poisci profil kjer je ime in starost manjsa od podane
    @GetMapping("poisci")
    public Iterable<Profil> poisci(@RequestParam(name = "ime") String ime, @RequestParam("starost") Integer starost){
        return profildao.poisciPoImeStarost(ime, starost);
    }

    //KLARA - starejsi od podane letnice, dolzina imena vsaj ali vecja kot podana, priimek zacne na podano crko
    @GetMapping("param")
    public Iterable<Profil> poisci(@RequestParam("starost") Long starost, @RequestParam("d_ime") Long dolzina_ime, @RequestParam("zacetnica_priimek") String zacetnica_pri){
        zacetnica_pri = zacetnica_pri + "%";
        return profildao.paramPoizvedbaA(starost, dolzina_ime, zacetnica_pri);
    }

}
