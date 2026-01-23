package org.example.pieces;

import org.example.entities.Board;
import org.example.entities.Cell;
import org.example.entities.Position;

import org.example.enums.PieceColour;
import org.example.enums.PieceType;

public abstract class Piece {
    private PieceColour colour;
    private PieceType pieceType;
    private boolean isCaptured;
    public Piece(PieceColour colour, PieceType type) {
        this.colour = colour;
        this.pieceType = type;
        this.isCaptured = false;
    }

    public PieceColour getColour() {
        return colour;
    }

    public void setColour(PieceColour colour) {
        this.colour = colour;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    //add functions
    boolean isPathClear(Board board, Cell startCell, Cell endCell) {
        int rowDir=Integer.compare(endCell.getPosition().getRow()-startCell.getPosition().getRow(),0);
        int colDir=Integer.compare(endCell.getPosition().getCol()-startCell.getPosition().getCol(),0);
        int currentRow=startCell.getPosition().getRow();
        int currentCol=startCell.getPosition().getCol();
        while(currentRow!=endCell.getPosition().getRow()&&currentCol!=endCell.getPosition().getCol()){
            if(board.getCell(new Position(currentRow,currentCol))!=null){
                return false;
            }
            currentRow=rowDir+1;
            currentCol=rowDir+1;
        }
        return true;
    }
    @Override
    public String toString() {
        String symbol=switch(this.pieceType){
            case KING ->  "K";
            case ROOK -> "R";
            case BISHOP -> "B";
            case QUEEN -> "Q";
            case PAWN -> "P";
            case KNIGHT -> "N";

        };
        return this.colour==PieceColour.WHITE ? symbol : symbol.toLowerCase();
    }

    public abstract boolean isValidMove(Board board, Cell start, Cell end);
}
