package com.aurionpro.model;

public class Board {
    private Cell[][] cells = new Cell[3][3];
    private MarkType startingMark = null;
    private MarkType lastMark = null;
    private int moveCount = 0;

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean setCellMark(int row, int col, MarkType mark) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        
        if (!cells[row][col].isEmpty()) {
            return false;
        }

        if (moveCount == 0) {
            startingMark = mark;
        } else {
            if (lastMark == mark) {
                return false;
            }
        }
        cells[row][col].setMark(mark);
        lastMark = mark;
        moveCount++;
        return true;
    }
    
    public int getMarkCount(MarkType mark) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getMark() == mark) count++;
            }
        }
        return count;
    }

    public MarkType getStartingMark() {
        return startingMark;
    }

    public int getMoveCount() {
        return moveCount;
    }
    
    public Cell[][] getCells() {
        return cells;
    }
    
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    
    public boolean isSymbolCountValid() {
        if (startingMark == null) return false;

        int xCount = getMarkCount(MarkType.X);
        int oCount = getMarkCount(MarkType.O);

        if (Math.abs(xCount - oCount) == 1) {
            return false;
        }

        if (xCount + oCount != 9) {
            return false;
        }

        return true;
    }
}