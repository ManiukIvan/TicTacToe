package TicTacToe.Players;

import TicTacToe.TicTacToeDesk;

public abstract class Player {
    protected int playerNumber;

    public abstract void makeMove(TicTacToeDesk desk);
}
