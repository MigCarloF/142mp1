package knightstour;

import java.util.Scanner;
import knightstour.ReusableFunc;

public class KnightsTour {

    public KnightsTour(){

        init();
        start();
    }

    public void start(){

    }

    public void init(){

        int boardLength;
        int boardWidth;

        Scanner sc = new Scanner(System.in);
        System.out.print("Length: ");
        boardLength = sc.nextInt();
        System.out.print("Width: ");
        boardWidth = sc.nextInt();

        int[][] board;

        board = setupBoard(boardLength, boardWidth);

        ReusableFunc.display(board);
    }

    public int[][] setupBoard(int length, int width){

        int[][] board = new int[length][width];

        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                board[i][j] = 0;
            }
        }

        board[0][0] = 1;

        return board;
    }
}
