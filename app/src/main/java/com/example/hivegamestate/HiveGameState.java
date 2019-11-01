/**
 *@author Marc Hilderbrand
 *@author Erik Liu
 *@author Phuocan Nguyen
 *@author Samuel Nguyen
 *@author Stephen Nguyen
 *
 *@version 10/10/19
 */

package com.example.hivegamestate;

//Comment by Stephen
//I assume this is used in network play, delete if it's unnecessary
import android.net.wifi.p2p.WifiP2pGroup;

import java.util.ArrayList;

public class HiveGameState {
    private final int BLACK_TURN = 0;
    private final int WHITE_TURN = 1;

    //the declaration of the board
    private piece[][] board = new piece[20][20];

    //int variable to tell whose turn it is
    //If 1, white moves, if 0, black moves
    //Removed static for now, not sure if it's needed
    //Let me (Stephen) know if it is
    private int turn = 1;  // Edit by Samuel Nguyen

    //Represents how many total pieces each player has
    private int player0Pieces;
    private int player1Pieces;

    public ArrayList<piece> bugList = new ArrayList<>();
    enum piece {
        BBEE, BSPIDER, BANT, BGHOPPER, BBEETLE, WBEE, WSPIDER, WANT, WGHOPPER, WBEETLE;
    }


    //Basic constructor
    public HiveGameState() {

        //1 BBEE, 2 BSPIDERS, 3 BANT, 3 BGHOPPER, 2,BBEETLE
        bugList.add(piece.BBEE);
        bugList.add(piece.BSPIDER);
        bugList.add(piece.BSPIDER);
        bugList.add(piece.BANT);
        bugList.add(piece.BANT);
        bugList.add(piece.BANT);
        bugList.add(piece.BGHOPPER);
        bugList.add(piece.BGHOPPER);
        bugList.add(piece.BGHOPPER);
        bugList.add(piece.BBEETLE);
        bugList.add(piece.BBEETLE);

        //1 BBEE, 2 WSPIDERS, 3 WANT, 3 WGHOPPER, 2,WBEETLE
        bugList.add(piece.WBEE);
        bugList.add(piece.WSPIDER);
        bugList.add(piece.WSPIDER);
        bugList.add(piece.WANT);
        bugList.add(piece.WANT);
        bugList.add(piece.WANT);
        bugList.add(piece.WGHOPPER);
        bugList.add(piece.WGHOPPER);
        bugList.add(piece.WGHOPPER);
        bugList.add(piece.WBEETLE);
        bugList.add(piece.WBEETLE);

        this.turn = WHITE_TURN; // White goes first?
        this.player0Pieces = 11;
        this.player1Pieces = 11;
    }

    //Copy constructor (Stephen)
    // Some edits by Samuel Nguyen
    public HiveGameState(HiveGameState hgs) {
        this.turn = hgs.turn;

        //Copies each board index/cell
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                this.board[i][j] = hgs.board[i][j];
            }
        }
        this.bugList = hgs.bugList;
    }

    //Returns a formatted string that describes the game's state
    @Override
    public String toString() {

        return "Turn: " + turn + "\n" +
                "BLACK_TURN: " + BLACK_TURN + "\n" +
                "WHITE_TURN: " + WHITE_TURN + "\n" +
                "White Bee: " + piece.WBEE.name() + 1 + "\n" +
                "White Spider: " + piece.WSPIDER.name() + 3 + "\n" +
                "White Ant: " + piece.WANT.name() + 3 + "\n" +
                "White Beetle: " + piece.WBEETLE.name() + 2 + "\n" +
                "White Grasshopper: " + piece.WGHOPPER.name() + 3 + "\n" +
                "Black Bee: " + piece.BBEE.name() + 1 +"\n" +
                "Black Spider: " + piece.BSPIDER.name() + 3 + "\n" +
                "Black Ant: " + piece.BANT.name() + 3 +"\n" +
                "Black Beetle: " + piece.BBEETLE.name() + 2 + "\n" +
                "Black Grasshopper: " + piece.BGHOPPER.name() + 1 + "\n";
    }

    // Following methods started by Samuel Nguyen

    /**
     * Places a piece on the board, subtracts one from total piece count and appropriate piece count,
     * and sets the turn to that of the other player.
     *
     * @param id: the id of whose turn it is
     * @param newPiece: the piece being moved
     * @param boardX: row index of where the piece is being placed on board
     * @param boardY: col index
     *
     * @return true if successful, false otherwise
     */

    // Below citation by Samuel Nguyen
    /**
     * External Citation
     * Date: October 10, 2019
     * Problem: I got "'equals()' between objects of inconvertible types 'piece' and 'String'".
     * Resource: https://developer.android.com/reference/java/lang/Enum
     * Solution: I used toString().
     */
    boolean placePiece(int id, piece newPiece, int boardX, int boardY) {
        if (id == WHITE_TURN) {
            // Cannot place pieces if there are no more to place
            if(player1Pieces == 0) {
                return false;
            }

            // Checks piece being placed
            if(newPiece.toString().equals("WBEE")) {
                bugList.remove(HiveGameState.piece.WBEE);
            }
            else if(newPiece.toString().equals("WSPIDER")) {
                bugList.remove(HiveGameState.piece.WSPIDER);
            }
            else if(newPiece.toString().equals("WANT")) {
                bugList.remove(HiveGameState.piece.WANT);
            }
            else if(newPiece.toString().equals("WBEETLE")) {
                bugList.remove(HiveGameState.piece.WBEETLE);
            }
            else if(newPiece.toString().equals("WGHOPPER")) {
                bugList.remove(HiveGameState.piece.WGHOPPER);
            }
            this.player1Pieces--;
        }
        else if (id == BLACK_TURN) {
            // Cannot place pieces if there are no more to place
            if(player0Pieces == 0) {
                return false;
            }

            // Checks piece being placed
            if(newPiece.toString().equals("BBEE")) {
                bugList.remove(HiveGameState.piece.BBEE);
            }
            else if(newPiece.toString().equals("BSPIDER")) {
                bugList.remove(HiveGameState.piece.BSPIDER);
            }
            else if(newPiece.toString().equals("BANT")) {
                bugList.remove(HiveGameState.piece.BANT);
            }
            else if(newPiece.toString().equals("BBEETLE")) {
                bugList.remove(HiveGameState.piece.BBEETLE);
            }
            else if(newPiece.toString().equals("BGHOPPER")) {
                bugList.remove(HiveGameState.piece.BGHOPPER);
            }
            this.player0Pieces--;
        }
        // Cannot place piece at occupied space
        if(board[boardX][boardY] != null) {
            return false;
        }

        board[boardX][boardY] = newPiece;
        if(id == WHITE_TURN) {
            this.setTurn(BLACK_TURN);
        }
        else if(id == BLACK_TURN) {
            this.setTurn(WHITE_TURN);
        }
        return true;
    }

    /**
     *Moves a piece on the board and sets the turn to that of the other player.
     *Pieces are just being moved to empty spaces (although the beetle can go anywhere);
     *this does not necessarily reflect movement rules.
     *
     * @param id: the id of whose turn it is
     * @param pieceOnBoard: the piece that will be moved
     * @param startX: the piece's starting X position
     * @param startY: the piece's starting Y position
     * @param newX: the piece's new X position
     * @param newY: the piece's new Y position
     * @return true if successful, false otherwise
     */
    boolean movePiece(int id, piece pieceOnBoard, int startX, int startY, int newX, int newY) {
        // Can't move piece to space it's already at
        if(startX == newX && startY == newY) {
            return false;
        }

        // Cannot move pieces of opposite color
        if(id == WHITE_TURN) {
            if(pieceOnBoard.toString().equals("BBEE") || pieceOnBoard.toString().equals("BSPIDER") ||
                    pieceOnBoard.toString().equals("BANT") || pieceOnBoard.toString().equals("BBEETLE")
                    || pieceOnBoard.toString().equals("BGHOPPER")) {
                return false;
            }
        }
        else if(id == BLACK_TURN) {
            if(pieceOnBoard.toString().equals("WBEE") || pieceOnBoard.toString().equals("WSPIDER") ||
                    pieceOnBoard.toString().equals("WANT") || pieceOnBoard.toString().equals("WBEETLE")
                    || pieceOnBoard.toString().equals("WGHOPPER")) {
                return false;
            }
        }

        // Cannot move to an occupied space (except beetles, not sure how to implement that)
        if(board[newX][newY] != null) {
            if(!pieceOnBoard.toString().equals("WBEETLE") &&
                    !pieceOnBoard.toString().equals("BBEETLE")) {
                return false;
            }
        }

        board[newX][newY] = pieceOnBoard;
        // Must remove what was at starting space
        board[startX][startY] = null;

        //Set next player turn accordingly.
        if(id == WHITE_TURN) {
            this.setTurn(BLACK_TURN);
        }
        else if(id == BLACK_TURN) {
            this.setTurn(WHITE_TURN);
        }
        return true;
    }

    /**
     * Undoes the last move. Not currently implemented as this
     * will solely be an extra method that will be made if there
     * is enough time.
     *
     * @param id: the id of whose turn it is
     * @return true if successful, false otherwise
     */
    boolean undo(int id) {
        if (id == WHITE_TURN || id == BLACK_TURN) {
            return true;
        }
        return false;
    }

    /**
     * Quits the game.
     * This is not fully implemented.
     *
     * @param id: the id of whose turn it is
     * @return true if successful, false otherwise
     */
    boolean quit(int id) {
        if(id == WHITE_TURN || id == BLACK_TURN) {
            // Quit method here
            return true;
        }
        return false;
    }

    /**
     * Zooms in or out on the screen.
     * This is not fully implemented.
     *
     * @param id: the id of whose turn it is
     * @return true if successful, false otherwise
     */
    boolean zoom(int id) {
        if (id == WHITE_TURN || id == BLACK_TURN) {
            // Zoom method here
            return true;
        }
        return false;
    }

    /**
     * Gets the id of whoever's move it is
     * @return id of player to move
     */
    int getTurn() {
        return this.turn;
    }

    /**
     * Sets the player to move
     * @param id: id of player that is being set to move
     */
    void setTurn(int id) {
        this.turn = id;
    }
}
