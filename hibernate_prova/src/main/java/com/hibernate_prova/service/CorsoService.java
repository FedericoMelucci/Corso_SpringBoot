package com.hibernate_prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate_prova.entity.Corso;
import com.hibernate_prova.repository.CorsoRepository;

@Service
public class CorsoService {
    
    @Autowired
    CorsoRepository corsoRep;




    public List<Corso> getListaCorsi() {

        return corsoRep.getListaCorsi();
    }
}
