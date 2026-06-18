package com.michele.cms.model;
//JPA che conterra lo specchio della tab del corso sdu mysql

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@Entity // specifica che questa classe è una tabella
@Table(name ="corsi") //indica che tabella
@NoArgsConstructor
public class Corso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    @NotBlank(message = "nome non valido non deve essere vuoto - mes personaliz")
    private String nome;
    
    @NonNull
    @NotBlank(message = "la descizione non deve essere vuota - mes personaliz")
    private String descrizione;
    
    @NonNull
    @Positive(message = "il prezzo deve essere valido, positivo - mes personaliz")
    private Double prezzo;
    
    @Enumerated(EnumType.STRING) //dice di salvarlo nella colonna con i valori in string e non 0 e 1 
    private StatoCorso stato = StatoCorso.BOZZA; //default value

    //DATE ZONE - automaticamente Hibernate crea e aggiorna le date da solo in base alla notazione

    @CreationTimestamp // alla creazione del record agisce e inserisc la data
    private LocalDateTime createdAt;
    
    @UpdateTimestamp //alla modifica del record agisce e modifica
    private LocalDateTime updatedAt;
}
