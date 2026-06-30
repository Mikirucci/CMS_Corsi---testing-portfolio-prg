package com.michele.cms.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.michele.cms.DTO.CorsoDTO;
import com.michele.cms.model.Corso;
import com.michele.cms.service.CorsoService;
import lombok.RequiredArgsConstructor;

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

@RestController
@RequestMapping("/api/corsi")
@RequiredArgsConstructor
public class CorsoController implements CorsoApi {

    private final CorsoService corsoService;
    private final com.michele.cms.mapper.CorsoMapper corsoMapper;

    @Override
    public List<CorsoDTO> getAll() {
        //pendiamo tutti i corsi dal service
        List<Corso> corsi = corsoService.getAll();
        return corsoMapper.toDTOList(corsi);
    }

    @Override
    public CorsoDTO getOne(Long id) {
        Corso corsoFind = corsoService.getOne(id);
        return corsoMapper.toDTO(corsoFind);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public CorsoDTO createCorso(CorsoDTO corsoDTO) {
        //mapper che trasferisce DTO in vera Entity
        Corso corso = corsoMapper.toEntity(corsoDTO);
        Corso newSavedCorso = corsoService.createCorso(corso);
        return corsoMapper.toDTO(newSavedCorso);
    }

    @Override
    public CorsoDTO modifyCorso(CorsoDTO corsoDTO, Long id) {
        Corso corso = corsoMapper.toEntity(corsoDTO);
        Corso modificato = corsoService.modifyCorso(id, corso);
        return corsoMapper.toDTO(modificato);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCorso(Long id) {
        corsoService.deleteCorso(id);
    }

    @Override
    public CorsoDTO publishCorso(Long id) {
        Corso corso = corsoService.publishCorso(id);
        return corsoMapper.toDTO(corso);
    }   

    @Override
    public List<CorsoDTO> searchName(String nome) {
        List<Corso> corsi = corsoService.searchName(nome);
        return corsoMapper.toDTOList(corsi);
    }
    
    
}
