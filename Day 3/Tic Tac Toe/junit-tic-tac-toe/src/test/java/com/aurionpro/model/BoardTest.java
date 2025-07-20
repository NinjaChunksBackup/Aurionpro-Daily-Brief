package com.aurionpro.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void newBoardShouldNotBeFull() {
        assertFalse(board.isBoardFull());
    }

    @Test
    void shouldSetMarkOnBoard() {
        assertTrue(board.setCellMark(0, MarkType.X));
        assertFalse(board.isBoardFull());
    }

    @Test
    void shouldReturnFalseWhenCellIsAlreadyMarkedOnBoard() {
        assertTrue(board.setCellMark(3, MarkType.O));
        assertFalse(board.setCellMark(3, MarkType.X));
    }

    @Test
    void boardShouldBeFullWhenAllCellsAreMarked() {
        for (int i = 0; i < 9; i++) {
            assertTrue(board.setCellMark(i, MarkType.X));
        }
        assertTrue(board.isBoardFull());
    }

    @Test
    void shouldReturnFalseWhenMarkingFullBoard() {
        for (int i = 0; i < 9; i++) {
            assertTrue(board.setCellMark(i, MarkType.X));
        }
        assertFalse(board.setCellMark(0, MarkType.O));
    }

    @Test
    void shouldReturnFalseForInvalidCellLocation() {
        assertFalse(board.setCellMark(-1, MarkType.X));
        assertFalse(board.setCellMark(9, MarkType.X));
        assertFalse(board.setCellMark(10, MarkType.X));
    }

    @Test
    void shouldNotAllowTwoConsecutiveSameMarks() {
        assertTrue(board.setCellMark(0, MarkType.X));
        assertFalse(board.setCellMark(1, MarkType.X));
        assertTrue(board.setCellMark(1, MarkType.O));
        assertFalse(board.setCellMark(2, MarkType.O));
        assertTrue(board.setCellMark(2, MarkType.X));
    }

    @Test
    void shouldValidateSymbolCountsAtGameEnd_XStarts() {
        assertTrue(board.setCellMark(0, MarkType.X));
        assertTrue(board.setCellMark(1, MarkType.O));
        assertTrue(board.setCellMark(2, MarkType.X));
        assertTrue(board.setCellMark(3, MarkType.O));
        assertTrue(board.setCellMark(4, MarkType.X));
        assertTrue(board.setCellMark(5, MarkType.O));
        assertTrue(board.setCellMark(6, MarkType.X));
        assertTrue(board.setCellMark(7, MarkType.O));
        assertTrue(board.setCellMark(8, MarkType.X));
        assertTrue(board.isSymbolCountValid());
    }

    @Test
    void shouldValidateSymbolCountsAtGameEnd_OStarts() {
        board = new Board();
        assertTrue(board.setCellMark(0, MarkType.O));
        assertTrue(board.setCellMark(1, MarkType.X));
        assertTrue(board.setCellMark(2, MarkType.O));
        assertTrue(board.setCellMark(3, MarkType.X));
        assertTrue(board.setCellMark(4, MarkType.O));
        assertTrue(board.setCellMark(5, MarkType.X));
        assertTrue(board.setCellMark(6, MarkType.O));
        assertTrue(board.setCellMark(7, MarkType.X));
        assertTrue(board.setCellMark(8, MarkType.O));
        assertTrue(board.isSymbolCountValid());
    }

}