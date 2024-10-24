package org.furb.dataStructure.exception;

public class StackIsEmptyException extends RuntimeException {

    public StackIsEmptyException() {
        super("Pilha vazia");
    }
}
