package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    Board(int boardSize,int numberOfSnakes,int numberOfLadders){
        initializeCells(boardSize);
        addSnakesLadders(numberOfSnakes,numberOfLadders);


    }
    private void initializeCells(int size){
        cells=new Cell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j]=new Cell();
            }
        }
    }
    private void addSnakesLadders(int snakes,int ladders){
        while(snakes>0){
            int snakeHead= ThreadLocalRandom.current().nextInt(1+ cells.length* cells.length-1);
            int snakeTail=ThreadLocalRandom.current().nextInt(1+ cells.length* cells.length-1);
            if(snakeHead<=snakeTail) continue;
            snakes--;
            Jump snakeObj=new Jump();
            snakeObj.start=snakeHead;
            snakeObj.end=snakeTail;

            Cell cell=getCell(snakeHead);
            cell.jump=snakeObj;

        }
        while(ladders>0){
            int ladderStart= ThreadLocalRandom.current().nextInt(1+ cells.length* cells.length-1);
            int ladderEnd=ThreadLocalRandom.current().nextInt(1+ cells.length* cells.length-1);
            if(ladderStart>=ladderEnd) continue;
            ladders--;
            Jump ladderObj=new Jump();
            ladderObj.start=ladderStart;
            ladderObj.end=ladderEnd;

            Cell cell=getCell(ladderStart);
            cell.jump=ladderObj;

        }
    }
    Cell getCell(int playerPosition){
        int max = cells.length * cells.length - 1;
        playerPosition = Math.min(playerPosition, max);

        int boardRow = playerPosition / cells.length;
        int boardCol = playerPosition % cells.length;
        return cells[boardRow][boardCol];
    }

}
