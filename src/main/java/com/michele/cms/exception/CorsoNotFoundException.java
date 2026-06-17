package com.michele.cms.exception;

public class CorsoNotFoundException extends RuntimeException {

public CorsoNotFoundException(Long id){
    super("corso con id: "+id+ " non trovato");
}

}
