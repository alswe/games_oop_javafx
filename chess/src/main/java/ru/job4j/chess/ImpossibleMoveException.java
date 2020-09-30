package ru.job4j.chess;

public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException() {
    }

    public ImpossibleMoveException(String message) {
        super(message);
    }
}
