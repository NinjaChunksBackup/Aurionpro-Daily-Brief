package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultAnalyzerTest {

    private Board board;
    private ResultAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        board = new Board();
        analyzer = new ResultAnalyzer(board);
    }

    @Test
    void testWinCondition() {
        board.setCellMark(0, 0, MarkType.X);
        board.setCellMark(1, 0, MarkType.O);
        board.setCellMark(0, 1, MarkType.X);
        board.setCellMark(1, 1, MarkType.O);
        board.setCellMark(0, 2, MarkType.X);

        assertEquals(ResultType.WIN, analyzer.analyzeResult());
    }

    @Test
    void testDrawCondition() {
        board.setCellMark(0, 0, MarkType.X);
        board.setCellMark(0, 1, MarkType.O);
        board.setCellMark(0, 2, MarkType.X);
        board.setCellMark(1, 1, MarkType.O);
        board.setCellMark(1, 0, MarkType.X);
        board.setCellMark(1, 2, MarkType.O);
        board.setCellMark(2, 1, MarkType.X);
        board.setCellMark(2, 0, MarkType.O);
        board.setCellMark(2, 2, MarkType.X);

        assertEquals(ResultType.DRAW, analyzer.analyzeResult());
    }

    @Test
    void testProgressCondition() {
        board.setCellMark(0, 0, MarkType.X);
        board.setCellMark(1, 1, MarkType.O);

        assertEquals(ResultType.INPROGRESS, analyzer.analyzeResult());
    }
}