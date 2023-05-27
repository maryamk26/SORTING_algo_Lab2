import java.util.Arrays;
import java.util.Random;

public class t9 {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);

        System.out.println("Original Array: " + Arrays.toString(arr));

        modifiedBubbleSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void modifiedBubbleSort(int[] arr) {
        int n = arr.length;

        boolean leftChange = true;
        boolean rightChange = true;

        while (leftChange || rightChange) {
            leftChange = false;
            for (int i = 0; i < n / 2 - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                    leftChange = true;
                }
            }

            rightChange = false;
            for (int i = n / 2; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    rightChange = true;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int length) {
        Random rand = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(10);
        }
        return arr;
    }
}
