import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class TicTacToe {
    private enum Mode{
        PlayerVSPlayer,
        PlayerVSComputer
    }
    private Mode mode;
    private int[][] field;
    private Scanner in;
    TicTacToe(){
        field = new int[3][3];
        in = new Scanner(System.in);
    }

    public void startGame(){
        //choosing game mode
        int gameMode = -1;
        System.out.println("Welcome to tic tac toe!");
        do {
            System.out.println("Please Chose game mode:\n" +
                    "1 - Player vs Player\n" +
                    "2 - Player vs Computer\n");
            try {
                gameMode = in.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println(e);
                gameMode = -1;
                in.next();
            }
        } while (gameMode!=1 && gameMode!=2);

        //setting game mode
        switch (gameMode){
            case 1:
                mode = Mode.PlayerVSPlayer;
                break;
            case 2:
                mode = Mode.PlayerVSComputer;
                break;
        }
        showField();


        while (!isGameOver()){
            //first player
            makePlayerMove(1);
            showField();
            if (isWinner()){
                System.out.println("First player win!");
                return;
            }
            if (isGameOver()){
                break;
            }
            //second player or computer move
            switch (mode){
                case PlayerVSComputer:
                    makeComputerMove();
                    break;
                case PlayerVSPlayer:
                    makePlayerMove(2);
            }
            showField();
            if (isWinner()){ switch (mode){
                case PlayerVSComputer:
                    System.out.println("Computer win!");
                    return;
                case PlayerVSPlayer:
                    System.out.println("Second player win!");
                    return;
            }
            }
        }
        System.out.println("Draw heat.");
    }
    public void setPlayerVSPlayerMode() {
        this.mode = Mode.PlayerVSPlayer;
    }
    public void setPlayerVSComputerMode() {
        this.mode = Mode.PlayerVSComputer;
    }
    //check if the game is over
    private boolean isGameOver(){
        //check free squares
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if (field[j][i]==0){
                    return false;//free square
                }
            }
        }
        //there is no free squares and winner
        return true;
    }
    //check if there is  winner
    private boolean isWinner(){

        //game end in two ways
        //first:there is row with 3 equals figures
        boolean isGameOver = true;
        for (int i=0;i<3;i++) {
            isGameOver = true;
            for (int j = 0; j < 2; j++) {
                if (field[i][j]!=field[i][j+1]){
                    isGameOver = false;
                    break;
                }
            }
            //there are 3 equals figures in i row and it is not 0
            if (isGameOver && field[i][0]!=0){
                return true;
            }
        }

        //second:there is column with 3 equals figures
        for (int i=0;i<3;i++) {
            isGameOver = true;
            for (int j = 0; j < 2; j++) {
                if (field[j][i]!=field[j+1][i]){
                    isGameOver = false;
                    break;
                }
            }
            //there are 3 equals figures in i columnm and it is not 0
            if (isGameOver && field[0][i]!=0){
                return true;
            }
        }

        //third:there is diagonal with 3 equals figures
        if ((field[0][0]==field[1][1] && field[1][1]==field[2][2] && field[0][0]!=0)||
                (field[0][2]==field[1][1] && field[1][1]==field[2][0] && field[0][2]!=0)){
            return true;
        }
        //there is no winner
        return false;

    }

    private void showField(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                switch (field[i][j]) {
                    case 1:
                        System.out.print("x");
                        break;
                    case 2:
                        System.out.print("0");
                        break;
                    default:
                        System.out.print(" ");
                        break;
                }
                if(j!=2){
                    System.out.print("|");
                }
            }if(i!=2){
                System.out.print("\n-----\n");
            }
        }
        System.out.print("\n*********************************\n");
    }

    private void makePlayerMove(int player){
        System.out.println(player+" player movement.");
        int x = -1;
        int y = -1;
        do {
            try {
                System.out.println("Enter position(x,y), where label will be put.");
                System.out.println("Enter x:");
                x = in.nextInt();
                System.out.println("Enter y:");
                y = in.nextInt();
            }
            catch (InputMismatchException e){
                x = -1;
                y = -1;
            }

        } while (!(0<=x&&x<=2 && 0<=y&&y<=2 && field[x][y]==0));
        field[x][y] = player;
    }

    private void makeComputerMove(){
        int x = -1;
        int y = -1;
        do {
            x = (int) (random() * 3);
            y = (int) (random() * 3);
        }while (field[x][y]!=0);
        field[x][y] = 2;
    }

}
