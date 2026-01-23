package org.example.entities;

public class Position {
    private int row;
    private int col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public boolean isValid() {
        return row >= 0 && col >= 0 && row<8 && col<8;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Position)) {
            return false;
        }
        Position position = (Position) o;
        return this.row == position.row && this.col == position.col;
    }
    @Override
    public String toString() {
        return (char) ('a' + col) +String.valueOf(row+1);
    }
}
