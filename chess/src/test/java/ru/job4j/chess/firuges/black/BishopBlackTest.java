package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack = (BishopBlack) bishopBlack.copy(Cell.F4);
        assertThat(bishopBlack.position(), is(Cell.F4));
    }

    @Test
    public void wayValid() throws ImpossibleMoveException {
        BishopBlack bishopBlackTest1 = new BishopBlack(Cell.C1);
        assertArrayEquals(bishopBlackTest1.way(Cell.G5), new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5});
        BishopBlack bishopBlackTest2 = new BishopBlack(Cell.A8);
        assertArrayEquals(bishopBlackTest2.way(Cell.H1), new Cell[]{Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1});
        BishopBlack bishopBlackTest3 = new BishopBlack(Cell.A1);
        assertArrayEquals(bishopBlackTest3.way(Cell.H8), new Cell[]{Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8});
    }

    @Test (expected = IllegalStateException.class)
    public void wayInvalid() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.B7);
        assertArrayEquals(bishopBlack.way(Cell.E5), new Cell[]{Cell.C7, Cell.D6, Cell.E5});
    }

    @Test
    public void isDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C4);
        assertThat(bishopBlack.isDiagonal(Cell.C4, Cell.E6), is(true));
        assertThat(bishopBlack.isDiagonal(Cell.B5, Cell.D3), is(true));
        assertThat(bishopBlack.isDiagonal(Cell.B2, Cell.F6), is(true));
        assertThat(bishopBlack.isDiagonal(Cell.B7, Cell.G2), is(true));
        assertThat(bishopBlack.isDiagonal(Cell.A1, Cell.A1), is(false));
        assertThat(bishopBlack.isDiagonal(Cell.F7, Cell.B4), is(false));
        assertThat(bishopBlack.isDiagonal(Cell.C2, Cell.D3), is(true));
    }

}