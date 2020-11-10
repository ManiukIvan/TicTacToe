import javafx.util.Pair;

import java.util.Scanner;

public class TicTacToePlayer extends Player {
    private Scanner in;

    public TicTacToePlayer(int playerNumber) {
        this.playerNumber = playerNumber;
        in = new Scanner(System.in);
    }

    @Override
    public void makeMove(TicTacToeDesk desk) {
        boolean moveIsNotMade = true;
        do {
            Pair<Integer, Integer> xy = chooseCell(desk.getDeskSize());
            int x = xy.getKey();
            int y = xy.getValue();
            if (desk.isFreeCell(x, y)) {
                desk.fillCell(x, y, playerNumber);
                moveIsNotMade = false;
            }
        } while (moveIsNotMade);
    }

    public Pair<Integer, Integer> chooseCell(int deskSize) {
        int x;
        int y;
        do {
            try {
                System.out.println("Enter position(x,y) of the cell.");
                System.out.println("Enter x:");
                x = Integer.parseInt(in.next());
                System.out.println("Enter y:");
                y = Integer.parseInt(in.next());
                if (!(0 <= x && x <=deskSize-1  && 0 <= y && y <= deskSize-1)) {
                    throw new TicTacToeException("There is no cell with coordinates:(" + x + "," + y + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter integer value");
                x = -1;
                y = -1;
            } catch (TicTacToeException e) {
                System.out.println(e.getMessage());
                x = -1;
                y = -1;
            }
        } while (x == -1 && y == -1);
        return new Pair<>(x, y);
    }

    @Override
    public String toString() {
        return "Player " + playerNumber;
    }
}