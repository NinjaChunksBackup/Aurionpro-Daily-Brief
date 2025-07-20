package com.aurionpro.model;

public class Board {
    private Cell[] cells = new Cell[9];
    private MarkType startingMark = null;
    private MarkType lastMark = null;
    private int moveCount = 0;

    public Board() {
        for (int i = 0; i < 9; i++) {
            cells[i] = new Cell();
        }
    }

    public boolean isBoardFull() {
        for (Cell cell : cells) {
            if (cell.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean setCellMark(int loc, MarkType mark) {
        if (loc < 0 || loc >= 9) {
            return false;
        }
        
        if (!cells[loc].isEmpty()) {
            return false;
        }

        if (moveCount == 0) {
            startingMark = mark;
        } else {
            if (lastMark == mark) {
                return false;
            }
        }
        cells[loc].setMark(mark);
        lastMark = mark;
        moveCount++;
        return true;
    }
    
    public int getMarkCount(MarkType mark) {
        int count = 0;
        for (Cell cell : cells) {
            if (cell.getMark() == mark) count++;
        }
        return count;
    }

    public MarkType getStartingMark() {
        return startingMark;
    }

    public int getMoveCount() {
        return moveCount;
    }
    
    public Cell[] getCells() {
        return cells;
    }
    
    public Cell getCell(int index) {
        return cells[index];
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