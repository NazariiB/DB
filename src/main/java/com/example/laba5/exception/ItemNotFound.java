package com.example.laba5.exception;

public class ItemNotFound extends RuntimeException{
    public ItemNotFound(Integer id) {
        super("Could not find item with id: " + id);
    }
}
