import java.util.Arrays;

public class t2 {
    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 5, 6};
        int[] changes = selectionSort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.println("Number of changes: [" + changes + "]");
    }

    public static int[] selectionSort(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        int changes = 0;
        for (int i = 0; i < sortedArray.length - 1; i++) {
            int minIndex = findMinIndex(sortedArray, i, sortedArray.length - 1);
            if (i != minIndex) {
                swap(sortedArray, i, minIndex);
                changes++;
            }
        }
        return sortedArray;
    }

    public static int findMinIndex(int[] array, int start, int end) {
        int minIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
