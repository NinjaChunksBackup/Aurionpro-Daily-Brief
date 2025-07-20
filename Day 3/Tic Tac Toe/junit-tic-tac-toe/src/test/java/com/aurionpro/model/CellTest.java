package com.aurionpro.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell();
    }

    @Test
    void newCellShouldBeEmpty() {
        assertTrue(cell.isEmpty());
        assertEquals(MarkType.EMPTY, cell.getMark());
    }

    @Test
    void shouldSetMarkOnEmptyCell() {
        assertTrue(cell.setMark(MarkType.X));
        assertFalse(cell.isEmpty());
        assertEquals(MarkType.X, cell.getMark());
    }

    @Test
    void shouldReturnFalseWhenMarkingANonEmptyCell() {
        assertTrue(cell.setMark(MarkType.O));
        assertFalse(cell.setMark(MarkType.X));
    }
}