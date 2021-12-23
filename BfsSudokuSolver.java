import java.util.*;

public class BfsSudokuSolver {
    static Scanner scan = new Scanner(System.in);
    static int row;
    static int col;

    public static class Bfs {
        int[][] board;

        public Bfs(int[][] board) {
            this.board = board;
        }
    }

    public static void main(String[] args) {
        example();

        while (true) {
            row = 0;
            col = 0;

            int[][] board = new int[9][9];
            input(board);

            Queue<Bfs> q = new LinkedList<>();
            Bfs bfs = new Bfs(board);
            q.add(bfs);

            long start = System.currentTimeMillis();
            solve(q);
            long end = System.currentTimeMillis();
            System.out.println("Turnaround Time (ms) : " + (end - start));

            if (!ctn()) {
                break;
            }
        }
    }

    public static void solve(Queue<Bfs> q) {
        if (q.size() == 0) {
            return;
        }
        if (row == 9) {
            out(q.poll());
            return;
        }

        int siz = q.size();
        for (int p = 0; p < siz; p++) {
            Bfs bfs = q.poll();
            if (bfs.board[row][col] != 0) {
                qadd(q, bfs, -1);
            } else {
                for (int i = 1; i < 10; i++) {
                    if (isValid(bfs.board, i)) {
                        qadd(q, bfs, i);
                    }
                }
            }
        }

        plusrc();
        solve(q);
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

    public static void qadd(Queue<Bfs> q, Bfs bfs, int p) {
        Bfs tempbfs = new Bfs(new int[9][9]);
        copy(tempbfs.board, bfs.board);

        if (p != -1) {
            tempbfs.board[row][col] = p;
        }
        q.add(tempbfs);
    }

    public static void copy(int[][] to, int[][] from) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                to[i][j] = from[i][j];
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

    public static void out(Bfs bfs) {
        int[][] board = bfs.board;
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
