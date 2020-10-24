import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class TicTacToe {

    private enum GameMode {
        PlayerVsPlayer,
        PlayerVsComputer
    }

    private TicTacToeDesk desk;
    private Player player1;
    private Player player2;
    private Player computer;
    private GameMode gameMode;

    public TicTacToe(int deskSize) {
        desk = new TicTacToeDesk(deskSize);
        chooseGameMode();
        player1 = new TicTacToePlayer(1);
        switch (gameMode){
            case PlayerVsPlayer:
                player2 =new TicTacToePlayer(2);
                break;
            case PlayerVsComputer:
                player2 =new TicTacToeComputerPlayer(2);
                break;
        }
        computer = new TicTacToeComputerPlayer(3);

    }

    public void startGame() {
        while (desk.isFreeCells()) {
            desk.showDesk();
            System.out.println(player1.toString() + ":");
            player1.makeMove(desk);
            if (desk.isWinner()) {
                desk.showDesk();
                endGame(player1);
                return;
            }

            desk.showDesk();
            System.out.println(player2.toString() + ":");
            player2.makeMove(desk);
            if (desk.isWinner()) {
                desk.showDesk();
                endGame(player2);
                return;
            }
        }
        endGame(null);

    }

    public void chooseGameMode() {
        System.out.println("Please Chose game mode:\n" +
                "1 - Player vs Player\n" +
                "2 - Player vs Computer\n");
        Scanner in = new Scanner(System.in);
        while (gameMode == null) {
            try {
                int inputNumber = Integer.parseInt(in.next());
                switch (inputNumber) {
                    case 1:
                        gameMode = GameMode.PlayerVsPlayer;
                        break;
                    case 2:
                        gameMode = GameMode.PlayerVsComputer;
                        break;
                    default:
                        System.out.println("Incorrect value.");
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Enter number  1 or 2");
            }
        }
    }

    public void endGame(Player winner) {
        if (winner != null) {
            System.out.println("Winner is " + winner.toString());
        } else {
            System.out.println("There is no winner, all cells are filled.");
        }
    }
}