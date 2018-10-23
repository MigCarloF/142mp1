package setcover;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SetCover {

    ArrayList<Integer> mainSet;
    ArrayList<ArrayList<Integer>> subsets;

    public SetCover(){
        //testInit();
        init();
        start();
    }

    private void testInit() {
        mainSet = new ArrayList<>();
        for(int i = 1; i < 9; i++) {
            mainSet.add(i);
        }
        subsets = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(1);
        subset.add(2);
        subsets.add(subset);

        subset = new ArrayList<>();
        subset.add(7);
        subset.add(8);
        subsets.add(subset);

        subset = new ArrayList<>();
        for(int i = 2; i < 8; i++) {
            subset.add(i);
        }
        subsets.add(subset);

        subset = new ArrayList<>();
        for(int i = 1; i < 5; i++){
            subset.add(i);
        }
        subsets.add(subset);

        subset = new ArrayList<>();
        for(int i = 5; i < 9; i++){
            subset.add(i);
        }
        subsets.add(subset);

        subset = new ArrayList<>();
        for(int i = 5; i < 8; i++){
            subset.add(i);
        }
        subsets.add(subset);
    }

    private void init(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input size for main set: ");
        int mainSetSize = sc.nextInt();


        System.out.println("Enter one by one each element of the main set (integer): ");
        mainSet = new ArrayList<>();
        for(int i = 0; i < mainSetSize; i++){
            while(true){
                int potentialInput = sc.nextInt();

                if(!mainSet.contains(potentialInput)) {
                    mainSet.add(potentialInput);
                    break;
                } else
                    System.out.println("Element exists. Enter another element");
            }
        }

        System.out.println("Enter how total number of subsets: ");
        int totalSubsets;
        while(true){

            totalSubsets = sc.nextInt();

            if(totalSubsets > 0)
                break;
            else
                System.out.println("Enter a positive number");
        }


        /**
         * loop flow
         * 1. total subsets
         * 2. total number in subset
         * 3. creating arrays in subset list
         * 4. individual element in subset
         */
        subsets = new ArrayList<>();
        for(int i = 0; i < totalSubsets; i++){
            ArrayList<Integer> subset = new ArrayList<>();
            int currentTotalElements;

            System.out.println("Enter total elements in subset " + (i + 1));
            while(true){
                currentTotalElements = sc.nextInt();
                if(currentTotalElements > 0)
                    break;
                else
                    System.out.println("Positive numbers only");
            }


            System.out.println("Enter individual elements in subset " + (i + 1));
            for(int j = 0; j < currentTotalElements; j++){
                while(true){
                    int potentialElement = sc.nextInt();

                    if(!subset.contains(potentialElement)){
                        subset.add(potentialElement);
                        break;
                    } else {
                        System.out.println("Element exists. Enter another number");
                    }
                }
            }

            Collections.sort(subset);
            subsets.add(subset);
        }
    }

    /**
     * runtime = O(n^2)
     */
    private void start(){

        //prints out the universal set
        System.out.print("U = {");
        for(int i = 0; i < mainSet.size(); i++){
            if(!(i == mainSet.size() - 1)){
                System.out.print(mainSet.get(i) + ", ");
            }else {
                System.out.println(mainSet.get(i) + "}");
            }
        }

        //prints out all subsets and their elements
        System.out.print("S = {");
        printSubset(subsets);
        System.out.println("}");

        //cont flag indicates that there was a match in one set of subsets. Loop ends when cont returns false
        boolean cont = true;
        ArrayList<ArrayList<Integer>> finalSubsets = new ArrayList<>();
        while(cont) {
            cont = false;
            int bestSubset = -1;
            int bestSubsetMatchCount = 0;
            for (int i = 0; i < subsets.size(); i++) {
                int subsetMatchCount = 0;
                for(int element : subsets.get(i)){
                    if(mainSet.contains(element)){
                        subsetMatchCount++;
                        cont = true;
                    }
                }
                if(subsetMatchCount > bestSubsetMatchCount){
                    bestSubsetMatchCount = subsetMatchCount;
                    bestSubset = i;
                }
            }

            if(cont){
                mainSet.removeAll(subsets.get(bestSubset));
                finalSubsets.add(subsets.get(bestSubset));
            }
        }

        System.out.print("C = {");
        printSubset(finalSubsets);
        System.out.println("}");
    }

    private void printSubset(ArrayList<ArrayList<Integer>> subset) {
        for(int i = 0; i < subset.size(); i++){
            System.out.print("{");
            ArrayList<Integer> currentSubset = subset.get(i);
            for(int j = 0; j < currentSubset.size(); j++){
                if(j == currentSubset.size() - 1)
                    System.out.print(currentSubset.get(j) + "}");
                else
                    System.out.print(currentSubset.get(j) + ", ");
            }
            if(!(i == subset.size()-1)){
                System.out.print(",");
            }
        }

    }

}
