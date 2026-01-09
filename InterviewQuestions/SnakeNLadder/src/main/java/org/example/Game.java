package org.example;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players=new LinkedList<>();
    Player winner;
    public  Game(){
        initialize();
    }
    private void initialize(){
        board=new Board(10,5,4);
        dice=new Dice(1);
        winner=null;
        addPlayers();

    }
    private void addPlayers(){
        Player p1=new Player("Player1",0);
        Player p2=new Player("Player2",0);
        players.add(p1);
        players.add(p2);
    }
    public void startGame(){
        while(winner==null){
            Player playerTurn=players.removeFirst();
            players.addLast(playerTurn);
            System.out.println("Player turn:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);
            int diceNumber=dice.rollDice();
            int playerNewPosition=playerTurn.currentPosition+diceNumber;
            playerNewPosition=jumpCheck(playerNewPosition,playerTurn);
            playerTurn.currentPosition = playerNewPosition;
            System.out.println("Player turn:" + playerTurn.id + " new Position is: " + playerNewPosition);
            if (playerNewPosition == board.cells.length * board.cells.length - 1) {
                winner = playerTurn;
            }

        }
        System.out.println("\n===> The Winner is:" + winner.id);
    }
    private int jumpCheck(int playerNewPosition, Player playerTurn){
        int maxPosition = board.cells.length * board.cells.length - 1;

        if (playerNewPosition > maxPosition) {
            return playerTurn.currentPosition; // stay where you are
        }
        Cell cell=board.getCell(playerNewPosition);
        if(cell.jump!=null && cell.jump.start==playerNewPosition){
            String jumpBy=(cell.jump.start<cell.jump.end)?"Ladder" : "Snake";
            System.out.println("[+] Jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }

}
