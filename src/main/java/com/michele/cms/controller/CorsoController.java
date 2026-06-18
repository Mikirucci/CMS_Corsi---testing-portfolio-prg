package com.michele.cms.controller;

/*
HttpStatus.OK                // 200
HttpStatus.CREATED           // 201
HttpStatus.NO_CONTENT        // 204

HttpStatus.BAD_REQUEST       // 400
HttpStatus.UNAUTHORIZED      // 401
HttpStatus.FORBIDDEN         // 403
HttpStatus.NOT_FOUND         // 404
HttpStatus.CONFLICT          // 409
HttpStatus.INTERNAL_SERVER_ERROR // 500 generico
*/

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Corso createCorso(Corso corso) {
        return corsoService.createCorso(corso);
    }

    @Override
    public Corso modifyCorso(Corso corso, Long id) {
        return corsoService.modifyCorso(id, corso);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
