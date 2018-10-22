package coinchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoinChange {

    ArrayList<Integer> coinValueList = new ArrayList<>();
    ArrayList<Coin> coins = new ArrayList<>();

    int amountToWithdraw;

    public CoinChange(){
        init();
        start();
    }

    public void init(){
        int totalCoins;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input total types of coins: ");

        totalCoins = sc.nextInt();

        System.out.println("Input unique coin values:");
        while(totalCoins-- > 0){
            do {
                int potentialCoin = sc.nextInt();
                if (!coinValueList.contains(potentialCoin)){
                    coinValueList.add(potentialCoin);
                    break;
                } else {
                    System.out.println("Coin exists, input another");
                }
            }while(true);
        }
        Collections.sort(coinValueList);

        for(int n : coinValueList){
            coins.add(new Coin(n));
        }

        System.out.print("Input amount to withdraw: ");
        amountToWithdraw = sc.nextInt();

    }

    public void start(){
        for(int i = coins.size() - 1; i >= 0; i--){
            if(coins.get(i).value <= amountToWithdraw){
                int amount2 = amountToWithdraw;
                amount2 = amountToWithdraw - (amountToWithdraw % coins.get(i).value);
                amountToWithdraw %= coins.get(i).value;
                coins.get(i).amount = amount2 / coins.get(i).value;
            }
        }

        for(Coin coin : coins){
            System.out.println(coin.value + " = " + coin.getAmount());
        }
    }




}
