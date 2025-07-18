package com.aurionpro.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void newBoardShouldNotBeFull() {
        Board board = new Board();
        assertFalse(board.isBoardFull());
    }

    @Test
    void shouldSetMarkOnBoard() throws CellAlreadyMarkedException {
        Board board = new Board();
        board.setCellMark(0, MarkType.X);
        assertFalse(board.isBoardFull());
    }

    @Test
    void shouldThrowExceptionWhenCellIsAlreadyMarkedOnBoard() throws CellAlreadyMarkedException {
        Board board = new Board();
        board.setCellMark(3, MarkType.O);
        assertThrows(CellAlreadyMarkedException.class, () -> {
            board.setCellMark(3, MarkType.X);
        });
    }

    @Test
    void boardShouldBeFullWhenAllCellsAreMarked() throws CellAlreadyMarkedException {
        Board board = new Board();
        for (int i = 0; i < 9; i++) {
            board.setCellMark(i, MarkType.X);
        }
        assertTrue(board.isBoardFull());
    }
}