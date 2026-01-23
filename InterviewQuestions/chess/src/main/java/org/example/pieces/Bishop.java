package org.example.pieces;

import org.example.entities.Board;
import org.example.entities.Cell;
import org.example.enums.PieceColour;
import org.example.enums.PieceType;

public class Bishop extends Piece {

    public Bishop(PieceColour colour) {
        super(colour, PieceType.BISHOP);
    }
    @Override
    public boolean isValidMove(Board board, Cell start, Cell end){
        if(start.equals(end)) return false;
        if(end.getPiece()!=null && end.getPiece().getColour()==start.getPiece().getColour()) return false;
        int rowDif=Math.abs(end.getPosition().getRow()-start.getPosition().getRow());
        int colDif=Math.abs(end.getPosition().getCol()-start.getPosition().getCol());
        if(rowDif==colDif && isPathClear(board,start,end)){
            Piece targetPiece=board.getCell(end.getPosition()).getPiece();
            return targetPiece==null || targetPiece.getColour()!=start.getPiece().getColour();
        }
        return false;
    }

}
