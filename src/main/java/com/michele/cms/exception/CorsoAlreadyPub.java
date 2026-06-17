package com.michele.cms.exception;

public class CorsoAlreadyPub extends RuntimeException {

    public CorsoAlreadyPub(Long id){
        super("il corso con id: "+id+" ha gia' lo stato PUBBLICATO");
    }
    
}
