package com.ris.pause_together.controllers;

import com.ris.pause_together.dao.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profili")
public class ProfilController {
    @Autowired
    private ProfilRepository profildao;

}
