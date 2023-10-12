package com.hibernate_prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate_prova.entity.Corso;
import com.hibernate_prova.service.CorsoService;

@RestController
@RequestMapping("/corso")
public class CorsoController {
    

    @Autowired
    CorsoService corsoService;


    @GetMapping()
    public List<Corso> getListaCorsi() {

        return corsoService.getListaCorsi();
    }
}
