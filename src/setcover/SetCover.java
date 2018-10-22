package setcover;

import java.util.ArrayList;
import java.util.Scanner;

public class SetCover {

    ArrayList<Integer> mainSet;
    ArrayList<ArrayList<Integer>> subsets;

    public SetCover(){
        init();
        start();
    }

    private void init(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input size for main set: ");
        int mainSetSize = sc.nextInt();

        System.out.println("Enter one by one each element of the main set (integer): ");
        for(int i = 0; i < mainSetSize; i++){
            while (true) {
                int potentialInput = sc.nextInt();

            }
        }
    }

    private void start(){

    }

}
