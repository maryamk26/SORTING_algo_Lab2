import java.util.Arrays;
import java.util.Random;

public class t7 {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;

        int[][] array = generateRandomArray(n, m);

        System.out.println("The array:");
        printArray(array);

        sortColumns(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    public static int[][] generateRandomArray(int n, int m) {
        int[][] array = new int[n][m];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        return array;
    }

    public static void sortColumns(int[][] array) {
        for (int j = 0; j < array[0].length; j++) {
            sortColumn(array, j);
        }
    }

    public static void sortColumn(int[][] array, int column) {
        for (int i = 1; i < array.length; i++) {
            int[] key = array[i];
            int j = i - 1;
            while (j >= 0 && compareArrays(array[j], key, column) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static int compareArrays(int[] arr1, int[] arr2, int column) {
        return Integer.compare(arr1[column], arr2[column]);
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();
    }
}
