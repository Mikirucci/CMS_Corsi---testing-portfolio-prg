package com.michele.cms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.michele.cms.model.Corso;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
/* ResponseCode:
2xx — Successo

200 — OK, richiesta riuscita
201 — Created, risorsa creata con successo (si usa con POST)
204 — No Content, riuscita ma nessun dato da restituire (si usa con DELETE)

4xx — Errore del client

400 — Bad Request, dati inviati non validi
401 — Unauthorized, non sei autenticato
403 — Forbidden, sei autenticato ma non hai i permessi
404 — Not Found, risorsa non trovata
409 — Conflict, risorsa già esistente (es. corso già pubblicato)

5xx — Errore del server

500 — Internal Server Error, qualcosa è andato storto nel backend

*/

@Tag(name = "corsi", description = "Api per gestione corsi nel cms")
public interface CorsoApi {

    @Operation(summary = "prende tutti i corsi presenti sul db", description = " descrizione lunga")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "lista corsi restituita con successo"),
        @ApiResponse(responseCode = "400", description = "Bad Request - dati inviati non validi"),
        //@ApiResponse(responseCode = "405", description = "Forbidden sei loggato ma non hai i permessi"),
        @ApiResponse(responseCode = "500", description = "lista corsi non restituita")
    })
    @GetMapping
    List<Corso> getAll();
    


    @Operation(summary = "cerca un corso specifico nel db", description = " descrizione lunga")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "lista corsi restituita con successo"),
        @ApiResponse(responseCode = "400", description = "Bad Request - dati inviati non validi"),
        //@ApiResponse(responseCode = "405", description = "Forbidden sei loggato ma non hai i permessi"),
        @ApiResponse(responseCode = "500", description = "lista corsi non restituita")
    })
    @GetMapping("/{id}")
    Corso getOne(@PathVariable Long id);



    @Operation(summary = "crea un corso nel db", description = " descrizione lunga")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created - lista corsi restituita con successo"),
        @ApiResponse(responseCode = "400", description = "Bad Request - dati inviati non validi"),
        //@ApiResponse(responseCode = "405", description = "Forbidden sei loggato ma non hai i permessi"),
    })
    @PostMapping
    Corso createCorso(@RequestBody Corso corso);



    @Operation(summary = "modifica dati di un corso nel db", description = " descrizione lunga")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created - lista corsi restituita con successo"),
        @ApiResponse(responseCode = "400", description = "Bad Request - dati inviati non validi"),
        //@ApiResponse(responseCode = "405", description = "Forbidden sei loggato ma non hai i permessi"),
    })
    @PutMapping("/{id}")
    Corso modifyCorso(@RequestBody Corso corso, @PathVariable Long id);



    @Operation(summary = "elimina corso dal db", description = " descrizione lunga")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "No Content"),
        @ApiResponse(responseCode = "404", description = "Bad Request - dati inviati non validi"),
        //@ApiResponse(responseCode = "405", description = "Forbidden sei loggato ma non hai i permessi"),
    })
    @DeleteMapping("/{id}")
    void deleteCorso( @PathVariable Long id);



    @Operation(summary = "modifica lo stato del corso dal db", description = " descrizione lunga")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "204", description = "No Content"),
        @ApiResponse(responseCode = "404", description = "Bad Request - dati inviati non validi"),
        //@ApiResponse(responseCode = "405", description = "Forbidden sei loggato ma non hai i permessi"),
    })
    @PutMapping("/{id}/publish")
    Corso publishCorso(@PathVariable Long id);

    

    
    @Operation(summary = "ricerca per nome del corso dal db", description = " descrizione lunga")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "204", description = "No Content"),
        @ApiResponse(responseCode = "404", description = "Bad Request - dati inviati non validi"),
        //@ApiResponse(responseCode = "405", description = "Forbidden sei loggato ma non hai i permessi"),
    })
    @GetMapping("/search")
    List<Corso> searchName(@RequestParam String nome);
}
