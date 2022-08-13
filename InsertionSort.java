public class InsertionSort {

    public static int[] sort(int[] arr) {

        int add, j;

        for (int i = 1; i < arr.length; i++) {
            add = arr[i];

            for (j = i - 1; j >= 0 && arr[j] >= add; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = add;
        }
        return arr;
    }

}
