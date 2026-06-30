package com.michele.cms.DTO;

import java.time.LocalDateTime;
import com.michele.cms.model.StatoCorso;
import lombok.Data;


@Data
public class CorsoDTO {

    private Long id;
    private String nome;
    private String descrizione;
    private Double prezzo;
    private StatoCorso stato;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
