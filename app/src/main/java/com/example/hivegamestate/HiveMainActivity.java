package com.example.hivegamestate;

import java.util.ArrayList;

public class HiveMainActivity extends GameMainActivity{

    // Define the allowed player types
    ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

    // Pig has two player types:  human and computer
        playerTypes.add(new GamePlayerType("Local Human Player") {
        public GamePlayer createPlayer(String name) {
            return new PigHumanPlayer(name);
        }});
        playerTypes.add(new GamePlayerType("Computer Player") {
        public GamePlayer createPlayer(String name) {
            return new PigComputerPlayer(name);
        }});
        playerTypes.add(new GamePlayerType("Smart Computer Player") {
        public GamePlayer createPlayer(String name) { return new PigSmartComputerPlayer(name);}});

    // Create a game configuration class for Pig:
    GameConfig defaultConfig = new GameConfig(playerTypes, 1, 2, "Pig", PORT_NUMBER);
        defaultConfig.addPlayer("Human", 0); // player 1: a human player
        defaultConfig.addPlayer("Computer", 1); // player 2: a computer player
        defaultConfig.setRemoteData("Remote Human Player", "", 0);

        return defaultConfig;
}//createDefaultConfig

    /**
     * create a local game
     *
     * @return
     * 		the local game, a pig game
     */
    @Override
    public LocalGame createLocalGame() {
        return new PigLocalGame();
    }
}
