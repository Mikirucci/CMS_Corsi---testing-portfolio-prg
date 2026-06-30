package com.michele.cms.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.michele.cms.DTO.CorsoDTO;
import com.michele.cms.model.Corso;


@Component
public class CorsoMapper {
    
    //CLIENT --> SERVER 
    public Corso toEntity(CorsoDTO corsoDTO) {
        Corso corso = new Corso();

        corso.setNome(corsoDTO.getNome());
        corso.setDescrizione(corsoDTO.getDescrizione());
        corso.setPrezzo(corsoDTO.getPrezzo());
        corso.setStato(corsoDTO.getStato());
        return corso;
    }

    public CorsoDTO toDTO(Corso corso){
        // SERVER --> CLIENT
        CorsoDTO corsoDTO = new CorsoDTO();

        corsoDTO.setId(corso.getId());
        corsoDTO.setNome(corso.getNome());
        corsoDTO.setDescrizione(corso.getDescrizione());
        corsoDTO.setPrezzo(corso.getPrezzo());
        corsoDTO.setStato(corso.getStato());
        corsoDTO.setCreatedAt(corso.getCreatedAt());
        corsoDTO.setUpdatedAt(corso.getUpdatedAt());
        return corsoDTO;
    }

/*Perché stream? Perché hai una lista di Entity e devi convertirle tutte in DTO. Lo stream le scorre una per una e chiama toDTO() su ognuna:   */
    public List<CorsoDTO> toDTOList(List<Corso> corsi){
        return corsi.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }


}
