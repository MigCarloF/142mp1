import coinchange.CoinChange;
import knightstour.KnightsTour;
import sorting.Sorting;

import java.util.Scanner;

public class Menu {

    public Menu(){
        start();
    }

    public void start(){

        int choice = -1;
        Scanner sc = new Scanner(System.in);


        System.out.println("MP1 142");
        System.out.println("1. Knight's Tour");
        System.out.println("2. Set Cover Problem");
        System.out.println("3. Coin Change Problem");
        System.out.println("4. Sorting an Array");
        System.out.println();
        System.out.println("Select Option: ");

        while(choice < 1 || choice > 4){
            choice = sc.nextInt();
        }

        switch (choice) {
            case 1:
                new KnightsTour();
                break;
            case 2:
                break;
            case 3:
                new CoinChange();
                break;
            case 4:
                new Sorting();
                break;
            default:
                System.out.println("Impossible event at main: switch choice");
        }
    }
}
