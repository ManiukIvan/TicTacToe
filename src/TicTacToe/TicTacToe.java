package TicTacToe;

import TicTacToe.Players.Player;
import TicTacToe.Players.TicTacToeComputerPlayer;
import TicTacToe.Players.TicTacToePlayer;

import java.util.Scanner;


public class TicTacToe {

    private enum GameMode {
        PlayerVsPlayer,
        PlayerVsComputer
    }

    private TicTacToeDesk desk;
    private Player firstPlayer;
    private Player secondPlayer;
    private GameMode gameMode;

    public TicTacToe(int deskSize) {
        desk = new TicTacToeDesk(deskSize);
        chooseGameMode();
        firstPlayer = new TicTacToePlayer(1);
        switch (gameMode) {
            case PlayerVsPlayer:
                secondPlayer = new TicTacToePlayer(2);
                break;
            case PlayerVsComputer:
                secondPlayer = new TicTacToeComputerPlayer(2);
                break;
        }
    }

    public void startGame() {
        Player winner = null;
        do {
            makePlayerMove(firstPlayer);
            if (desk.isWinner()){
                winner = firstPlayer;
                break;
            }
            makePlayerMove(secondPlayer);
            if (desk.isWinner()){
                winner = secondPlayer;
                break;
            }
        } while (desk.isFreeCells());
        endGame(winner);

    }

    public void makePlayerMove(Player player){
        desk.showDesk();
        System.out.println(player.toString() + ":");
        player.makeMove(desk);
    }
    public void chooseGameMode() {
        System.out.println("Please Chose game mode:\n" +
                "1 - TicTacToe.TicTacToe.Players.Player vs TicTacToe.TicTacToe.Players.Player\n" +
                "2 - TicTacToe.TicTacToe.Players.Player vs Computer\n");
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