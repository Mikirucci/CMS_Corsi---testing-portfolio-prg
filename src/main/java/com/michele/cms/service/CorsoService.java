package com.michele.cms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.michele.cms.exception.CorsoAlreadyPub;
import com.michele.cms.exception.CorsoNotFoundByName;
import com.michele.cms.exception.CorsoNotFoundException;
import com.michele.cms.model.Corso;
import com.michele.cms.model.StatoCorso;
import com.michele.cms.repository.CorsoRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CorsoService {
    @Autowired
    private CorsoRepository corsoRepository;

//restituisce tutti i corsi (List)
public List<Corso> getAll(){
    List<Corso> allCorsi = corsoRepository.findAll();
    log.info("numero di corsi trovati: {}", allCorsi.size());
    return allCorsi;
}

public Corso getOne(Long id){
    Optional<Corso> corso = corsoRepository.findById(id); //optional per quando cerchi un singolo elemento che potrebbe non stare
    log.info("corso trovato: {}", corso);
    return corso.orElseThrow(() -> new CorsoNotFoundException(id)); //orElseThrow si usa quando si ha ogg con Optional
}

/* @Transactional
garantisce transizione ovvero quando ci sono piu operazioni in una funzione
o vanno a buon fine tutte o non fare niente quindi:
1. lettura - buon fine
2. salvataggio - non buon fine
esito: non fare nulla ne 1 ne 2
*/ 
@Transactional  
public Corso createCorso(Corso corso){
    log.info("corso creato {} ", corso);
    return corsoRepository.save(corso);

}

@Transactional
public Corso modifyCorso(Long id, Corso corso){
    Corso corsoEsistente = getOne(id);
    log.info("corso: {}", corsoEsistente);

    corsoEsistente.setNome(corso.getNome());
    corsoEsistente.setDescrizione(corso.getDescrizione());
    corsoEsistente.setPrezzo(corso.getPrezzo());

    log.info("corso con modifiche {}", corsoEsistente);
    return corsoRepository.save(corsoEsistente);
    
}

@Transactional
public void deleteCorso(Long id){
    Corso corsoDaEliminare = getOne(id);
    log.info("corso da eliminare {}", corsoDaEliminare);
    corsoRepository.delete(corsoDaEliminare);
}

@Transactional
public Corso publishCorso(long id){
    Corso corsoDaPubblicare = getOne(id);
    
    if(corsoDaPubblicare.getStato().equals(StatoCorso.PUBBLICATO) ){
        corsoDaPubblicare.setStato(StatoCorso.BOZZA);
    }else {
        corsoDaPubblicare.setStato(StatoCorso.PUBBLICATO);
    }
        log.info("corso PUBBLICATO: {}", corsoDaPubblicare);
        return corsoRepository.save(corsoDaPubblicare);
    
      // scrivere eccezione
}

public List<Corso> searchName(String nome){
    List<Corso> corsoDaCercare = corsoRepository.findByNomeContainingIgnoreCase(nome);
    if(corsoDaCercare.isEmpty()){
        throw new CorsoNotFoundByName(nome);
    }
    return corsoDaCercare;
}

}
