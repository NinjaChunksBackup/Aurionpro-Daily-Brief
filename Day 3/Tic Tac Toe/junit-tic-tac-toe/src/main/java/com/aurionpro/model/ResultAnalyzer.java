package com.aurionpro.model;

public class ResultAnalyzer {
    private Board board;
    private ResultType result;

    public ResultAnalyzer(Board board) {
        this.board = board;
        this.result = ResultType.INPROGRESS;
    }

    private boolean horizontalWinCheck() {
        for (int i = 0; i < 3; i++) {
            if (checkThreeCells(i, 0, i, 1, i, 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean verticalWinCheck() {
        for (int i = 0; i < 3; i++) {
            if (checkThreeCells(0, i, 1, i, 2, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkThreeCells(int r1, int c1, int r2, int c2, int r3, int c3) {
        MarkType mark1 = board.getCell(r1, c1).getMark();
        MarkType mark2 = board.getCell(r2, c2).getMark();
        MarkType mark3 = board.getCell(r3, c3).getMark();
        return mark1 != MarkType.EMPTY &&
               mark1 == mark2 &&
               mark1 == mark3;
    }

    private boolean diagonalWinCheck() {
        if (checkThreeCells(0, 0, 1, 1, 2, 2)) {
            return true;
        }
        if (checkThreeCells(0, 2, 1, 1, 2, 0)) {
            return true;
        }
        return false;
    }

    public ResultType analyzeResult() {
        if (horizontalWinCheck() || verticalWinCheck() || diagonalWinCheck()) {
            result = ResultType.WIN;
        } else if (board.isBoardFull()) {
            result = ResultType.DRAW;
        } else {
            result = ResultType.INPROGRESS;
        }
        return result;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ResultType getResult() {
        return result;
    }

    public void setResult(ResultType result) {
        this.result = result;
    }
}