package com.enigma.sepotifay.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String id, Class classs) {
        super("Resources id with "+ id + "of class "+classs.getClass()+"Not found");
    }
}
