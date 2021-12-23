import java.util.*;

public class DfsSudokuSolver {
    static Scanner scan = new Scanner(System.in);
    static int row;
    static int col;

    public static void main(String[] args) {
        example();
        while (true) {
            row = 0;
            col = 0;

            int[][] board = new int[9][9];
            input(board);

            long start = System.currentTimeMillis();
            solve(board);
            out(board);
            long end = System.currentTimeMillis();
            System.out.println("Turnaround Time (ms) : " + (end - start));

            if (!ctn()) {
                break;
            }
        }
    }

    public static boolean solve(int[][] board) {
        if (row == 9) {
            return true;
        }

        if (board[row][col] != 0) {
            plusrc();
            boolean flag = solve(board);
            minusrc();
            return flag;
        } else {
            for (int i = 1; i < 10; i++) {
                if (isValid(board, i)) {
                    board[row][col] = i;
                    plusrc();
                    if (solve(board)) {
                        return true;
                    }
                    minusrc();
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    public static void example() {
        System.out.println("input example:\n"
                + "530070000\r\n"
                + "600195000\r\n"
                + "098000060\r\n"
                + "800060003\r\n"
                + "400803001\r\n"
                + "700020006\r\n"
                + "060000280\r\n"
                + "000419005\r\n"
                + "000080079");
    }

    public static void input(int[][] board) {
        System.out.println("\nYour sudoku is...");
        for (int i = 0; i < 9; i++) {
            String temp = scan.nextLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = temp.charAt(j) - 48;
            }
        }
    }

    public static boolean isValid(int[][] board, int c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c || board[row][i] == c) {
                return false;
            }
        }

        for (int i = (row / 3) * 3; i < (row / 3 + 1) * 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3 + 1) * 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void plusrc() {
        if (col == 8) {
            row++;
            col = 0;
        } else {
            col++;
        }
    }

    public static void minusrc() {
        if (row != 0 && col == 0) {
            row--;
            col = 8;
        } else {
            col--;
        }
    }

    public static void out(int[][] board) {
        System.out.println("\nThe answer is...");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println("");
        }
    }

    public static boolean ctn() {
        System.out.println("\nContinue? (y/n)");
        char c = scan.next().charAt(0);
        scan.nextLine();
        if (c == 'n') {
            return false;
        }
        return true;
    }
}