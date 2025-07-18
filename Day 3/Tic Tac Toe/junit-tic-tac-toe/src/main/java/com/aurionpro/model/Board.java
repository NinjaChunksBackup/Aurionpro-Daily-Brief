package com.aurionpro.model;

public class Board {
    private Cell[] cells = new Cell[9];

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

    public void setCellMark(int loc, MarkType mark) throws CellAlreadyMarkedException {
        cells[loc].setMark(mark);
    }
}