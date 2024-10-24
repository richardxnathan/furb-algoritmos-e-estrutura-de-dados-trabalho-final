package org.furb.dataStructure.exception;

public class StackIsFullException extends RuntimeException {

        public StackIsFullException() {
            super("Pilha cheia");
        }
}
