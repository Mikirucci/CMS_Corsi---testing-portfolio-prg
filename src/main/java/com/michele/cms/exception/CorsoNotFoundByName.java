package com.michele.cms.exception;

public class CorsoNotFoundByName extends RuntimeException {

    public CorsoNotFoundByName(String nome){
        super("non esistono corsi con questo nome" +nome);
    }

}
