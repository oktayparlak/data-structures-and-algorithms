package algorithms;

public class BubbleSort {

    public static int[] sort(int[] arr) {

        int temp, i, k;

        for (i = 0; i < arr.length - 1; i++) {
            for (k = 0; k < arr.length - 1; k++) {
                if (arr[k] > arr[k + 1]) {
                    temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }
        return arr;
    }

}
