package com.aurionpro.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void newCellShouldBeEmpty() {
        Cell cell = new Cell();
        assertTrue(cell.isEmpty());
        assertEquals(MarkType.EMPTY, cell.getMark());
    }

    @Test
    void shouldSetMarkOnEmptyCell() throws CellAlreadyMarkedException {
        Cell cell = new Cell();
        cell.setMark(MarkType.X);
        assertFalse(cell.isEmpty());
        assertEquals(MarkType.X, cell.getMark());
    }

    @Test
    void shouldThrowExceptionWhenMarkingANonEmptyCell() throws CellAlreadyMarkedException {
        Cell cell = new Cell();
        cell.setMark(MarkType.O);
        assertThrows(CellAlreadyMarkedException.class, () -> {
            cell.setMark(MarkType.X);
        });
    }
}