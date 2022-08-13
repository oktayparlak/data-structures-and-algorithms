public class SelectionSort {

    public static int[] sort(int[] arr) {

        int i, index, j, smallest;

        for (i = 0; i < arr.length - 1; i++) {

            smallest = arr[arr.length - 1];
            index = arr.length - 1;

            for (j = i; j < arr.length - 1; j++) {
                if (arr[j] < smallest) {
                    smallest = arr[j];
                    index = j;
                }
            }

            arr[index] = arr[i];
            arr[i] = smallest;
        }
        return arr;
    }

}
