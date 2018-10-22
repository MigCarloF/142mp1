package sorting;

import javax.xml.transform.sax.SAXSource;
import java.util.Scanner;

import static java.lang.System.*;

public class Sorting {

    int[] arr;

    public Sorting(){
        setupArray();
        start();
    }

    private void setupArray(){
        Scanner sc = new Scanner(in);
        out.print("Enter number of input:");
        int arrLen = sc.nextInt();

        arr = new int[arrLen];

        System.out.println("Inputs: ");
        for(int i = 0; i < arrLen; i++){

            arr[i] = sc.nextInt();

        }
    }

    private void start(){
        int currMinIndex = 0;


        for(int i = 0; i < arr.length; i++){
            currMinIndex = i;
            for(int j = i; j < arr.length; j++){
                int one = arr[j];
                int two = arr[currMinIndex];
                if (one < two) {
                    currMinIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[currMinIndex];
            arr[currMinIndex] = temp;
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }

    }
}
