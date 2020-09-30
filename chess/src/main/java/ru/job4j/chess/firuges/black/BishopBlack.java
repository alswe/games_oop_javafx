package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX;
        int deltaY;

        if (position.getX() - dest.getX() < 0) {
            deltaX = 1;
        } else {
            deltaX = -1;
        }
        if (position.getY() - dest.getY() < 0) {
            deltaY = 1;
        } else {
            deltaY = -1;
        }
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(position.getX() + deltaX * (index + 1), position.getY() + deltaY * (index + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (source.equals(dest)) {
            return false;
        }
        if ((source.getX() - dest.getX()) + (source.getY() - dest.getY()) == 0) {
            return true;
        }
        if ((source.getX() - dest.getX()) == (source.getY() - dest.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
