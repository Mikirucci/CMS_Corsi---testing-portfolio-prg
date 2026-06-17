package com.michele.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michele.cms.model.Corso;
import com.michele.cms.service.CorsoService;


@RestController
@RequestMapping("/api/corsi")
public class CorsoController implements CorsoApi {

    @Autowired
    private CorsoService corsoService;

    @Override
    public List<Corso> getAll() {
        return corsoService.getAll();
    }

    @Override
    public Corso getOne(Long id) {
        return corsoService.getOne(id);
    }

    @Override
    public Corso createCorso(Corso corso) {
        return corsoService.createCorso(corso);
    }

    @Override
    public Corso modifyCorso(Corso corso, Long id) {
        return corsoService.modifyCorso(id, corso);
    }

    @Override
    public void deleteCorso(Long id) {
        corsoService.deleteCorso(id);
    }

    @Override
    public Corso publishCorso(Long id) {
        return corsoService.publishCorso(id);
    }

    @Override
    public List<Corso> searchName(String nome) {
        return corsoService.searchName(nome);
    }
    
}
