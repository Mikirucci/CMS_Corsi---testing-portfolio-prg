/*
qui saranno scritte tutte le quary per la tabella corso
usando
JpaRepository<Corso, Long> dove Corso è la tab e Long è la pk (type) 
abbiamo le quary base già pronte:
findAll() — tutti i corsi
findById(id) — corso per id
save(corso) — crea o aggiorna
deleteById(id) — cancella
*/
package com.michele.cms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.michele.cms.model.Corso;


public interface CorsoRepository extends JpaRepository<Corso, Long> {
    //aggiunta di query personalizzate
    List<Corso> findByNomeContainingIgnoreCase(String nome);
}
