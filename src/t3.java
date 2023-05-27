import java.util.Arrays;
import java.util.Random;

public class t3 {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int[][] a = generateRandomArray(n, m);

        int changes = sortColumns(a);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println("Index changes: " + changes);
    }

    public static int[][] generateRandomArray(int n, int m) {
        int[][] array = new int[n][m];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = rand.nextInt(10);
            }
        }
        return array;
    }

    public static int sortColumns(int[][] array) {
        int changes = 0;
        for (int j = 0; j < array[0].length; j++) {
            changes += sortColumn(array, j);
        }
        return changes;
    }

    public static int sortColumn(int[][] array, int columnIndex) {
        int changes = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < array.length; k++) {
                if (array[k][columnIndex] < array[minIndex][columnIndex]) {
                    minIndex = k;
                }
            }
            if (i != minIndex) {
                int temp = array[i][columnIndex];
                array[i][columnIndex] = array[minIndex][columnIndex];
                array[minIndex][columnIndex] = temp;
                changes++;
            }
        }
        return changes;
    }
}
