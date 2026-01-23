package org.example.entities;

import org.example.enums.GameStatus;
import org.example.enums.PieceColour;
import org.example.pieces.King;
import org.example.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private GameStatus gameStatus;
    private Player currentPlayer;
    private List<Move> moveHistory;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        if (player1.getPlayingSide().equals(PieceColour.WHITE)) {
            this.currentPlayer = player1;
        }
        else{
            this.currentPlayer = player2;
        }
        this.gameStatus=GameStatus.IN_PROGRESS;
        this.moveHistory=new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public boolean playMove(Player player, Position start,Position end) {
        Cell startCell = board.getCell(start);
        Cell endCell = board.getCell(end);
        Move move=new Move(player,startCell,endCell);
        return this.makeMove(move,player);
    }
    private boolean makeMove(Move move, Player player) {
        Piece startPiece=move.getStart().getPiece();
        Piece endPiece=move.getEnd().getPiece();
        if(startPiece==null || startPiece.getColour()!=player.getPlayingSide()) return false;
        if(!startPiece.isValidMove(board,move.getStart(),move.getEnd())) return false;
        if(endPiece!=null) {
            endPiece.setCaptured(true);
            move.setPieceKilled(endPiece);
        }
        move.setPieceMoved(startPiece);
        move.getEnd().setPiece(endPiece);
        move.getStart().setPiece(null);
        this.moveHistory.add(move);

        if(endPiece instanceof King){
            System.out.println("\n===>>> Its a Checkmate!!!");
            if(player.getPlayingSide()==PieceColour.WHITE){
                this.setGameStatus(GameStatus.WHITE_WIN);
                System.out.println("===>>> Game Status: " + this.getGameStatus());
            }
            else{
                this.setGameStatus(GameStatus.BLACK_WIN);
                System.out.println("===>>> Game Status: " + this.getGameStatus());
            }
        }
        if(currentPlayer==player1) this.currentPlayer=player2;
        else this.currentPlayer=player1;
        return true;

    }
    public void displayMovesHistory() {
        for (Move move : moveHistory) {
            System.out.println(move);
        }
    }

    public void display() {
        System.out.println("\nCurrent turn: " + currentPlayer);
        System.out.println("Game status: " + gameStatus);
    }

}
