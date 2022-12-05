package com.ris.pause_together.controllers;

import com.ris.pause_together.dao.UporabnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uporabniki")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikdao;


}
