public class TicTacToe {

    private TicTacToeDesk desk;
    private TicTacToePlayer player1;
    private TicTacToePlayer player2;

    public TicTacToe(int deskSize) {
        desk = new TicTacToeDesk(deskSize);
        player1 = new TicTacToePlayer(1);
        player2 = new TicTacToePlayer(2);

    }

    public void startGame() {
        while (desk.isFreeCells()) {
            desk.showDesk();
            System.out.println(player1.toString() + ":");
            player1.makeMove(desk);
            if (desk.isWinner()) {
                endGame(player1);
                break;
            }

            desk.showDesk();
            System.out.println(player1.toString() + ":");
            player2.makeMove(desk);
            if (desk.isWinner()) {
                endGame(player2);
                break;
            }
        }
        endGame(null);

    }

    public void endGame(TicTacToePlayer winner) {
        if (winner != null) {
            System.out.println("Winner is " + player1.toString());
        } else {
            System.out.println("There is no winner, all cells are filled.");
        }
    }
}
