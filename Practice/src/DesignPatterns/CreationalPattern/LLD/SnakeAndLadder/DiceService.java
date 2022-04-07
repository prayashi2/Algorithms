package DesignPatterns.CreationalPattern.LLD.SnakeAndLadder;

import java.util.Random;

public class DiceService {

    public int roll() {
        return new Random().nextInt(6) + 1;
    }
}
