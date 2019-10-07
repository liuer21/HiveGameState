package com.example.hivegamestate;

public class HiveGameState {
    //static variable to tell whose turn it is
    static int turn;

    static final int BLACK_TURN = 0;
    static final int WHITE_TURN = 1;

    //holds a 2d array of strings for what the board would look like
    //using a 2d array for now, idk if we will used a linked list later on
    //once we get the class for the pieces set up, we can change string to that new class
    static String[][] board = new String[100][100];

    //holds the value for how many pieces the white and black player have in their hand (not on board)
    static int wBee, wSpider, wAnt, wBeetle, wGrasshopper;
    static int bBee, bSpider, bAnt, bBeetle, bGrasshopper;

    //Returns a formatted string that describes the game's state
    @Override
    public String toString()
    {
        return "Turn: " + turn + "/n" +
                "BLACK_TURN: " + BLACK_TURN + "/n" +
                "WHITE_TURN: " + WHITE_TURN + "/n" +
                "White Bee: " + wBee + "/n" +
                "White Spider: " + wSpider + "/n" +
                "White Ant: " + wAnt + "/n" +
                "White Beetle: " + wBeetle + "/n" +
                "White Grasshopper: " + wGrasshopper + "/n" +
                "Black Bee: " + bBee + "/n" +
                "Black Spider: " + bSpider + "/n" +
                "Black Ant: " + bAnt + "/n" +
                "Black Beetle: " + bBeetle + "/n" +
                "Black Grasshopper: " + bGrasshopper + "/n" +
                board;

    }
}
