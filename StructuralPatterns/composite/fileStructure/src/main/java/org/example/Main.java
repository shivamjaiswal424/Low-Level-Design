package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Composite Design Pattern");
        File receipts  =new File("receipts.txt");
        File invoices  =new File("invoices.txt");
        File torrentLinks  =new File("torrentLinks.txt");
        File tomCruise =new File("tomCruise.jpg");
        File dumbAndDumber=new  File("dumbAndDumber.mp4");
        File hangover1=new File("hangover1.mp4");

        Directory movies=new Directory("movies");
        Directory comedyMovies=new Directory("comedyMovies");
        movies.addChild(receipts);
        movies.addChild(torrentLinks);
        movies.addChild(tomCruise);
        movies.addChild(invoices);
        movies.addChild(comedyMovies);
        comedyMovies.addChild(hangover1);
        comedyMovies.addChild(dumbAndDumber);

        movies.printContents();


    }
}