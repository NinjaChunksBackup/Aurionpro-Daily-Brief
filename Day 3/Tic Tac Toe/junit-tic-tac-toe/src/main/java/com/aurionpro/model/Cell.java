package com.aurionpro.model;

public class Cell {
    private MarkType mark;

    public Cell() {
        this.mark = MarkType.EMPTY;
    }

    public boolean isEmpty() {
        return this.mark == MarkType.EMPTY;
    }

    public MarkType getMark() {
        return this.mark;
    }

    public boolean setMark(MarkType mark) {
        if (!isEmpty()) {
            return false;
        }
        this.mark = mark;
        return true;
    }
}