package com.aurionpro.model;

public class ResultAnalyzer {
    private Board board;
    private ResultType result;

    public ResultAnalyzer(Board board) {
        this.board = board;
        this.result = ResultType.INPROGRESS;
    }

    private boolean horizontalWinCheck() {
        if (checkThreeCells(0, 1, 2)) {
            return true;
        }
        if (checkThreeCells(3, 4, 5)) {
            return true;
        }
        if (checkThreeCells(6, 7, 8)) {
            return true;
        }
        return false;
    }

    private boolean verticalWinCheck() {
        if (checkThreeCells(0, 3, 6)) {
            return true;
        }
        if (checkThreeCells(1, 4, 7)) {
            return true;
        }
        if (checkThreeCells(2, 5, 8)) {
            return true;
        }
        return false;
    }

    private boolean checkThreeCells(int pos1, int pos2, int pos3) {
        MarkType mark1 = board.getCell(pos1).getMark();
        MarkType mark2 = board.getCell(pos2).getMark();
        MarkType mark3 = board.getCell(pos3).getMark();
        return mark1 != MarkType.EMPTY &&
               mark1 == mark2 &&
               mark1 == mark3;
    }

    private boolean diagonalWinCheck() {
        if (checkThreeCells(0, 4, 8)) {
            return true;
        }
        if (checkThreeCells(2, 4, 6)) {
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