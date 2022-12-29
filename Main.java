import algorithms.*;

public class Main {

    public static void main(String[] args) {

        int[] arry = {5,3,1,0,8,55,3}; // create an array

        int[] sorted = BubbleSort.sort(arry); // choose a algorithm


        for (int item : sorted) {
            System.out.print(item + " "); // print to console
        }


    }
}