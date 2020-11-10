package TicTacToe;

public class TicTacToeDesk {
    private final int deskSize;
    private int[][] cells;

    public TicTacToeDesk(int deskSize) {
        this.deskSize = deskSize;
        cells = new int[deskSize][deskSize];
    }

    public int getDeskSize() {
        return deskSize;
    }

    public void fillCell(int x, int y, int cellValue){
        cells[x][y] = cellValue;
    }

    public boolean isFreeCell(int x, int y) {
        boolean isFree = false;
        if (cells[x][y] == 0) {
            isFree = true;
        }
        return isFree;
    }

    public boolean isFreeCells() {
        for (int i = 0; i < deskSize; i++) {
            for (int j = 0; j < deskSize; j++) {
                if (cells[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNotNullColumnsWithEqualCells() {
        boolean isColumnWithEqualCells;
        for (int i = 0; i < deskSize; i++) {
            isColumnWithEqualCells = true;
            for (int j = 0; j < deskSize - 1; j++) {
                if (cells[j][i] != cells[j + 1][i]) {
                    isColumnWithEqualCells = false;
                    break;
                }
            }
            if (isColumnWithEqualCells && cells[0][i] != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotNullRowsWithEqualCells() {
        boolean isRowWithEqualCells;
        for (int i = 0; i < deskSize; i++) {
            isRowWithEqualCells = true;
            for (int j = 0; j < deskSize - 1; j++) {
                if (cells[i][j] != cells[i][j + 1]) {
                    isRowWithEqualCells = false;
                    break;
                }
            }
            if (isRowWithEqualCells && cells[i][0] != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotNullDiagonalWithEqualCells() {
        boolean isDiagonalWithEqualCells = true;
        //check first diagonal
        for (int i = 0; i < deskSize - 1; i++) {
            if (cells[i][i] != cells[i + 1][i + 1]) {
                isDiagonalWithEqualCells = false;
                break;
            }
        }
        //check tht not null
        if (isDiagonalWithEqualCells && cells[0][0] == 0) {
            isDiagonalWithEqualCells = false;
        }
        if (!isDiagonalWithEqualCells) {
            //check second
            for (int i = 0; i < deskSize - 1; i++) {
                if (cells[i][deskSize - 1 - i] != cells[i + 1][deskSize - 1 - i - 1]) {
                    isDiagonalWithEqualCells = false;
                    break;
                }
            }
        }
        //check tht not null
        if (isDiagonalWithEqualCells && cells[deskSize - 1][0] == 0) {
            isDiagonalWithEqualCells = false;
        }
        return isDiagonalWithEqualCells;
    }

    public boolean isWinner() {
        return isNotNullColumnsWithEqualCells() || isNotNullRowsWithEqualCells() || isNotNullDiagonalWithEqualCells();
    }

    public void showDesk() {
        for (int i = 0; i < deskSize; i++) {
            for (int j = 0; j < deskSize; j++) {
                switch (cells[i][j]) {
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
                if (j != deskSize - 1) {
                    System.out.print("|");
                }
            }
            if (i != deskSize - 1) {
                System.out.print("\n-----\n");
            }
        }
        System.out.print("\n");
    }

}
