import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {5, 4, 1, 3, 2};
        int[] b = {23, 14, 5, 56, -7, 9, 18, 34, 0, 2};

        selectionSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println();

        selectionSort(b);
        System.out.println(Arrays.toString(b));
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = findMinIndex(array, i);
            swap(array, i, minIndex);
        }
    }

    public static int findMinIndex(int[] array, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
