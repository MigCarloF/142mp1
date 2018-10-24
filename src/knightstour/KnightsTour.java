package knightstour;

import java.util.ArrayList;
import java.util.Scanner;

public class KnightsTour {

    private Cell[][] board;
    private int boardLength;
    private int boardWidth;

    public KnightsTour(){
        //testInit();
        init();
        start();
    }

    private void start(){
        Cell currCell = board[0][0];
        validateMoves(currCell);

        int spacesLeft = boardLength * boardWidth;
        spacesLeft--; //for the initial space

        while(true){

            int leastMovesCount = -1;
            Cell leastMovesCell = null;
            currCell.traversed = true;

            for(Cell cell : currCell.possibleMoves){
                validateMoves(cell);
                if(cell.possibleMoves.size() < leastMovesCount || leastMovesCount == -1){
                    leastMovesCell = cell;
                    leastMovesCount = cell.possibleMoves.size();
                }
            }

            if(leastMovesCell == null){
                if(spacesLeft > 0) {
                    System.out.println("Whoops! We cannot continue! End of the line");
                    break;
                } else {
                    System.out.println("We did it!!");
                    break;
                }
            }
            currCell = leastMovesCell;
            spacesLeft--;
            currCell.traversed = true;
            display(board);
            System.out.println("----------------------------");
        }
    }

    private int validateMoves(Cell cell){
        //if a cell has been previously validated, we do not need to check again
        if(cell.validated) {
            ArrayList<Cell> cellsToRemove = new ArrayList<>();
            for(Cell cell2 : cell.possibleMoves){
                if(cell2.traversed){
                    cellsToRemove.add(cell2);
                }
            }
            cell.possibleMoves.removeAll(cellsToRemove);
            return cell.possibleMoves.size();
        }

        int validMoves = 0;
        int tentativeX = cell.getX() - 1;
        int tentativeY = cell.getY() - 2;
        if(checkBounds(tentativeX, tentativeY) && !board[tentativeY][tentativeX].traversed) {
            validMoves++;
            cell.possibleMoves.add(board[tentativeY][tentativeX]);
        }

        tentativeX = cell.getX() + 1;
        tentativeY = cell.getY() - 2;
        if(checkBounds(tentativeX, tentativeY) && !board[tentativeY][tentativeX].traversed) {
            validMoves++;
            cell.possibleMoves.add(board[tentativeY][tentativeX]);
        }

        tentativeX = cell.getX() + 2;
        tentativeY = cell.getY() - 1;
        if(checkBounds(tentativeX, tentativeY) && !board[tentativeY][tentativeX].traversed) {
            validMoves++;
            cell.possibleMoves.add(board[tentativeY][tentativeX]);
        }

        tentativeX = cell.getX() + 2;
        tentativeY = cell.getY() + 1;
        if(checkBounds(tentativeX, tentativeY) && !board[tentativeY][tentativeX].traversed) {
            validMoves++;
            cell.possibleMoves.add(board[tentativeY][tentativeX]);
        }

        tentativeX = cell.getX() + 1;
        tentativeY = cell.getY() + 2;
        if(checkBounds(tentativeX, tentativeY) && !board[tentativeY][tentativeX].traversed) {
            validMoves++;
            cell.possibleMoves.add(board[tentativeY][tentativeX]);
        }

        tentativeX = cell.getX() - 1;
        tentativeY = cell.getY() + 2;
        if(checkBounds(tentativeX, tentativeY) && !board[tentativeY][tentativeX].traversed) {
            validMoves++;
            cell.possibleMoves.add(board[tentativeY][tentativeX]);
        }

        tentativeX = cell.getX() - 2;
        tentativeY = cell.getY() + 1;
        if(checkBounds(tentativeX, tentativeY) && !board[tentativeY][tentativeX].traversed) {
            validMoves++;
            cell.possibleMoves.add(board[tentativeY][tentativeX]);
        }

        tentativeX = cell.getX() - 2;
        tentativeY = cell.getY() - 1;
        if(checkBounds(tentativeX, tentativeY) && !board[tentativeY][tentativeY].traversed){
            validMoves++;
            cell.possibleMoves.add(board[tentativeY][tentativeX]);
        }

        cell.validated = true;
        return validMoves;
    }

    private boolean checkBounds(int x, int y){
        return x >= 0 && y >= 0 && x < boardWidth && y < boardLength;
    }

    private void testInit(){
        boardWidth = 8;
        boardLength = 8;

        board = setupBoard(boardLength, boardWidth);
        Cell.setBoard(board);
        display(board);
    }
    private void init(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Length: ");
        boardLength = sc.nextInt();
        System.out.print("Width: ");
        boardWidth = sc.nextInt();

        board = setupBoard(boardLength, boardWidth);
        Cell.setBoard(board);
        display(board);
    }

    private Cell[][] setupBoard(int length, int width){

        Cell[][] board = new Cell[length][width];

        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                board[i][j] = new Cell(i, j);
                board[i][j].traversed = false;
            }
        }

        board[0][0].traversed = true;

        return board;
    }
    private static void display(Cell[][] arr){
        /*
          arr.length = length of array
          arr[0].length = width of array
         */

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j].traversed ? 1 + " " : 0 + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
