package knightstour;

public class ReusableFunc {

    public static void display(int[][] arr){
        /**
         * arr.length = length of array
         * arr[0].length = width of array
         */

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
