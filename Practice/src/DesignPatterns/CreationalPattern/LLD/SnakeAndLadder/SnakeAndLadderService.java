package DesignPatterns.CreationalPattern.LLD.SnakeAndLadder;

import java.util.Queue;

public class SnakeAndLadderService {

    private SnakeAndLadderBoard snakeAndLadderBoard;
    private int initialNumberOfPlayers;
    private Queue<Player> players;
    private boolean isGameCompleted;

    private int noOfDices;
    private boolean shouldGameContinueTillLastPlayer;
    private boolean shouldAllowMultipleDiceRollOnSix;

    private static final int DEFAULT_BOARD_SIZE = 100;
    private static final int DEFAULT_NO_OF_DICES = 1;
}
