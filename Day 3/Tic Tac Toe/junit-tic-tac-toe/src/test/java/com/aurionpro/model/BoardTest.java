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
        assertTrue(board.setCellMark(0, 0, MarkType.X));
        assertFalse(board.isBoardFull());
    }

    @Test
    void shouldReturnFalseWhenCellIsAlreadyMarkedOnBoard() {
        assertTrue(board.setCellMark(1, 0, MarkType.O));
        assertFalse(board.setCellMark(1, 0, MarkType.X));
    }

    @Test
    void boardShouldBeFullWhenAllCellsAreMarked() {
        board.setCellMark(0, 0, MarkType.X);
        board.setCellMark(0, 1, MarkType.O);
        board.setCellMark(0, 2, MarkType.X);
        board.setCellMark(1, 0, MarkType.O);
        board.setCellMark(1, 1, MarkType.X);
        board.setCellMark(1, 2, MarkType.O);
        board.setCellMark(2, 0, MarkType.X);
        board.setCellMark(2, 1, MarkType.O);
        board.setCellMark(2, 2, MarkType.X);
        assertTrue(board.isBoardFull());
    }

    @Test
    void shouldReturnFalseWhenMarkingFullBoard() {
        board.setCellMark(0, 0, MarkType.X);
        board.setCellMark(0, 1, MarkType.O);
        board.setCellMark(0, 2, MarkType.X);
        board.setCellMark(1, 0, MarkType.O);
        board.setCellMark(1, 1, MarkType.X);
        board.setCellMark(1, 2, MarkType.O);
        board.setCellMark(2, 0, MarkType.X);
        board.setCellMark(2, 1, MarkType.O);
        board.setCellMark(2, 2, MarkType.X);
        assertFalse(board.setCellMark(0, 0, MarkType.O));
    }

    @Test
    void shouldReturnFalseForInvalidCellLocation() {
        assertFalse(board.setCellMark(-1, 0, MarkType.X));
        assertFalse(board.setCellMark(0, 3, MarkType.X));
        assertFalse(board.setCellMark(3, 0, MarkType.X));
    }

    @Test
    void shouldNotAllowTwoConsecutiveSameMarks() {
        assertTrue(board.setCellMark(0, 0, MarkType.X));
        assertFalse(board.setCellMark(0, 1, MarkType.X));
        assertTrue(board.setCellMark(0, 1, MarkType.O));
        assertFalse(board.setCellMark(0, 2, MarkType.O));
        assertTrue(board.setCellMark(0, 2, MarkType.X));
    }

    @Test
    void shouldValidateSymbolCountsAtGameEnd_XStarts() {
        board.setCellMark(0, 0, MarkType.X);
        board.setCellMark(0, 1, MarkType.O);
        board.setCellMark(0, 2, MarkType.X);
        board.setCellMark(1, 0, MarkType.O);
        board.setCellMark(1, 1, MarkType.X);
        board.setCellMark(1, 2, MarkType.O);
        board.setCellMark(2, 0, MarkType.X);
        board.setCellMark(2, 1, MarkType.O);
        board.setCellMark(2, 2, MarkType.X);
        assertTrue(board.isSymbolCountValid());
    }

    @Test
    void shouldValidateSymbolCountsAtGameEnd_OStarts() {
        board = new Board();
        board.setCellMark(0, 0, MarkType.O);
        board.setCellMark(0, 1, MarkType.X);
        board.setCellMark(0, 2, MarkType.O);
        board.setCellMark(1, 0, MarkType.X);
        board.setCellMark(1, 1, MarkType.O);
        board.setCellMark(1, 2, MarkType.X);
        board.setCellMark(2, 0, MarkType.O);
        board.setCellMark(2, 1, MarkType.X);
        board.setCellMark(2, 2, MarkType.O);
        assertTrue(board.isSymbolCountValid());
    }

}