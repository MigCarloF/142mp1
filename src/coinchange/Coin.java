package coinchange;

public class Coin {
    int value;
    int amount;

    public Coin(int value){
        this.value = value;
        amount = 0;
    }

    public void incAmount(){
        amount++;
    }

    public int getAmount(){
        return amount;
    }
}
