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
    public Iterable<Uporabnik> vrniUporabnike(){
        return uporabnikdao.vrniUporabnike();
    }

    //KLARA
    @GetMapping("/usernames")
    public Iterable<String> vsiUporabnikiUserName(){
        return uporabnikdao.poisciVseUpoUN();
    }

    //KLARA
    @PostMapping
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik upo){
        System.out.println(upo);
        return uporabnikdao.save(upo);
    }

    //KLARA
    @DeleteMapping("izbrisi/{id}")
    public void izbrisiUporabnika(@PathVariable("id") Long id){
      uporabnikdao.deleteById(id);
    }

    // KLARA - kompleksnejsa poizvedba s vsaj tremi parametri (mysql)
    // vrne uporabnike, ki imajo ustvarjen vsaj en seznam, username manjsi od 10 crk ter, geslo daljse od 7
    @GetMapping("poizvedbaA")
    public Iterable<Uporabnik> upoPoizvedbaA(){
        return uporabnikdao.upoPoizvedbaA();
    }

    //KLARA - kompleksnejsa poizvedba s vsaj tremi parametri (mysql)
    //vrne uporabnike, ki nimajo ustvarjenega seznama, email je null, geslo je manjse od 5
    @GetMapping("poizvedbaB")
    public Iterable<Uporabnik> upoPoizvedbaB(){
        return uporabnikdao.upoPoizvedbaB();
    }

    /*
    @GetMapping("poisci")
    public Iterable<Uporabnik> upoParam(@RequestParam("ime_parametra")){return uporabnikdao.upoParam();}
     */

}
