import java.util.Arrays;

public class t1 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        selectionSort(arr);
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }

    public static int findMinIndex(int[] arr, int start, int end) {
        int minIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = findMinIndex(arr, i, arr.length - 1);
            swap(arr, i, minIndex);
        }
    }
}
