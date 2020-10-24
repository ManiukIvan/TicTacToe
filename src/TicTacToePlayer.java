import javafx.util.Pair;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToePlayer {
    private Scanner in;
    private int playerNumber;

    public TicTacToePlayer(int playerNumber) {
        this.playerNumber = playerNumber;
        in = new Scanner(System.in);
    }

    public void makeMove(TicTacToeDesk desk) {
        boolean isMadeMove = false;
        while (!isMadeMove) {
            Pair<Integer, Integer> xy = chooseCell();
            try {
                desk.fillCell(xy.getKey(), xy.getValue(), playerNumber);
                isMadeMove = true;
            } catch (TicTacToeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Pair<Integer, Integer> chooseCell() {
        int x = -1;
        int y = -1;
        while (x == -1 && y == -1) {
            try {
                System.out.println("Enter position(x,y) of the cell.");
                System.out.println("Enter x:");
                x = Integer.parseInt(in.next());
                System.out.println("Enter y:");
                y = Integer.parseInt(in.next());
            } catch (NumberFormatException e) {
                x = -1;
                y = -1;
            }
        }
        return new Pair<>(x, y);
    }

    @Override
    public String toString() {
        return "Player "+playerNumber;
    }
}