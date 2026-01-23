package org.example.pieces;

import org.example.entities.Board;
import org.example.entities.Cell;
import org.example.entities.Position;
import org.example.enums.PieceColour;
import org.example.enums.PieceType;

public class Pawn extends Piece {

    public Pawn(PieceColour colour) {
        super(colour, PieceType.PAWN);
    }

    @Override
    public boolean isValidMove(Board board, Cell start, Cell end) {
        if(start.equals(end)) return false;
        if(end.getPiece()!=null && end.getPiece().getColour()==start.getPiece().getColour()) return false;
        int direction=this.getColour()==PieceColour.WHITE ? 1 : -1;
        int rowDiff=Math.abs(end.getPosition().getRow()-start.getPosition().getRow());
        int colDiff=Math.abs(end.getPosition().getCol()-start.getPosition().getCol());
        if(colDiff==0 && rowDiff==1){
            return board.getCell(end.getPosition()).getPiece()==null;
        }
        if(colDiff==0 && !hasMovedBefore(start) && rowDiff==2){
            Position intermediate = new Position(start.getPosition().getRow() + direction, start.getPosition().getCol());
            return board.getCell(intermediate).getPiece() == null && board.getCell(end.getPosition()).getPiece() == null;

        }
        if (colDiff == 1 && rowDiff == 1) {
            Piece targetPiece = board.getCell(end.getPosition()).getPiece();
            return targetPiece != null && targetPiece.getColour() != start.getPiece().getColour();
        }
        return false;

    }
    private boolean hasMovedBefore(Cell start){
        return start.getPosition().getRow()!=1 && start.getPosition().getCol()!=6;
    }
}
