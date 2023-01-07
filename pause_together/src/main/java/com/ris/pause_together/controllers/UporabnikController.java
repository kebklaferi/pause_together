package com.ris.pause_together.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ris.pause_together.dao.UporabnikRepository;
import com.ris.pause_together.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@RestController
@RequestMapping("/uporabniki")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikdao;
    ObjectMapper objectMapper = new ObjectMapper();

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

    @PutMapping("/spremeni/{id}")
    public void spremeniUporabnika(@RequestBody String jsonObjekt, @PathVariable("id") Long id) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(jsonObjekt);
        String ime = jsonNode.get("username").asText();
        uporabnikdao.spremeniUsernameUpo(ime, id);
    }

    //KLARA
    @DeleteMapping("izbrisi/{id}")
    public void izbrisiUporabnika(@PathVariable("id") Long id){
      uporabnikdao.deleteById(id);
    }

    // KLARA - kompleksnejsa poizvedba s vsaj dvema - tremi parametri (mysql) sprint 2
    // vrne uporabnike, ki imajo ustvarjen vsaj en seznam, username manjsi od 10 crk ter, geslo daljse od 7
    @GetMapping("poizvedbaA")
    public Iterable<Uporabnik> upoPoizvedbaA(){
        return uporabnikdao.upoPoizvedbaA();
    }

    //KLARA - kompleksnejsa poizvedba s vsaj dvema - tremi parametri (mysql) sprint 2
    //vrne uporabnike, ki nimajo ustvarjenega seznama, email je null, geslo je manjse od 5
    @GetMapping("poizvedbaB")
    public Iterable<Uporabnik> upoPoizvedbaB(){
        return uporabnikdao.upoPoizvedbaB();
    }

    //KLARA - kompleksnejsa poizvedba s vsaj tremi parametri (mysql) sprint 3
    //vrne uporabnike, ki so starejsi od x let, imajo seznam na katerem je vsaj 1 pesem
    @GetMapping("tretjisprint")
    public Iterable<Uporabnik> upoTretjiSprint(@RequestParam("leta") Long leta){
        return uporabnikdao.upoTretjiSprint(leta);
    }

    //registracija
    @PostMapping("/registracija")
    public boolean registrirajUporabnika(@RequestBody Uporabnik uporabnik) throws NoSuchAlgorithmException {
        List<Uporabnik> uporabniki = uporabnikdao.preglejMaile(uporabnik.getEmail());
        if(uporabniki.size() > 0) return false;
        String geslo = uporabnik.getGeslo();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(geslo.getBytes(StandardCharsets.UTF_8));
        byte [] b = md.digest();
        String hex_g = String.format("%064x", new BigInteger(1, b));
        uporabnik.setGeslo(hex_g);
        uporabnikdao.save(uporabnik);
        return true;
    }

    //prijava
    @PostMapping("/prijava")
    public boolean prijavi(@RequestBody String jsonObjekt) throws JsonProcessingException, NoSuchAlgorithmException, UnsupportedEncodingException {
        JsonNode jsonNode = objectMapper.readTree(jsonObjekt);
        String geslo = jsonNode.get("geslo").asText();
        String email = jsonNode.get("email").asText();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(geslo.getBytes(StandardCharsets.UTF_8));
        byte [] b = md.digest();
        String hex_g = String.format("%064x", new BigInteger(1, b));
        List<Uporabnik> listUpo = uporabnikdao.vrniPrijavo(email, hex_g);
        if(listUpo.size() > 0) return true;
        else return false;
    }
}
