package recursion;
import java.util.*;
public class KnightsTour {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        int row = sc.nextInt(), col = sc.nextInt();
        sc.close();
        printKnightsTour(chess, row, col, 1);

    }

    public static void printKnightsTour(int[][] chess, int row, int col, int count) {
        if (row >= chess.length || col >= chess.length || row < 0 || col < 0 || chess[row][col] > 0) {
            return;
        } else if (count == chess.length * chess.length) {
            chess[row][col] = count;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        //System.out.println("pre all");
        chess[row][col] = count;
        printKnightsTour(chess, row - 2, col + 1, count + 1);
        printKnightsTour(chess, row - 1, col + 2, count + 1);
        printKnightsTour(chess, row + 1, col + 2, count + 1);
        printKnightsTour(chess, row + 2, col + 1, count + 1);
        printKnightsTour(chess, row + 2, col - 1, count + 1);
        printKnightsTour(chess, row + 1, col - 2, count + 1);
        printKnightsTour(chess, row - 1, col - 2, count + 1);
        printKnightsTour(chess, row - 2, col - 1, count + 1);
        chess[row][col] = 0;

    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
