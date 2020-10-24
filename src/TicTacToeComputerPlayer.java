import javafx.util.Pair;

import java.util.Scanner;

import static java.lang.Math.random;

public class TicTacToeComputerPlayer extends Player {

    public TicTacToeComputerPlayer(int computerNumber) {
        this.number = computerNumber;
    }


    @Override
    public void makeMove(TicTacToeDesk desk) {
        boolean isMadeMove = false;
        while (!isMadeMove) {
            int x = (int) (random() * desk.getDeskSize());
            int y = (int) (random() * desk.getDeskSize());
            try {
                desk.fillCell(x, y, number);
                isMadeMove = true;
            } catch (TicTacToeException e) {
            }
        }
    }

    @Override
    public String toString() {
        return "Computer " + number;
    }
}