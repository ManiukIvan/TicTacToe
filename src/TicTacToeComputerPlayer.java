import javafx.util.Pair;

import java.util.Scanner;

import static java.lang.Math.random;

public class TicTacToeComputerPlayer extends Player {

    public TicTacToeComputerPlayer(int computerNumber) {
        this.playerNumber = computerNumber;
    }


    @Override
    public void makeMove(TicTacToeDesk desk) {
        boolean moveIsNotMade = true;
        do {
            int x = (int) (random() * desk.getDeskSize());
            int y = (int) (random() * desk.getDeskSize());
            if (desk.isFreeCell(x,y)) {
                desk.fillCell(x, y, playerNumber);
                moveIsNotMade = false;
            }
        } while (moveIsNotMade);
    }

    @Override
    public String toString() {
        return "Computer " + playerNumber;
    }
}