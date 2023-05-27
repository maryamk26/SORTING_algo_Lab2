import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array {
    private int[] array;

    public Array(int size) {
        array = new int[size];
    }

    public Array(int[] array) {
        this.array = array;
    }

    public void initializeArray(int value) {
        Arrays.fill(array, value);
    }

    public void input() {
        try (Scanner scs = new Scanner(System.in)) {
            for (int i = 0; i < array.length; i++) {
                System.out.print("Enter element " + i + ": ");
                array[i] = scs.nextInt();
            }
        }
    }

    public void fillRandom(int min, int max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
    }

    public int getElement(int i) {
        return array[i];
    }

    public void setElement(int i, int value) {
        array[i] = value;
    }

    public int getSum() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public int getLargestElement() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int getIndexOfSmallestElement() {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public Array getPositiveElements() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }
        int[] positiveElements = new int[count];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positiveElements[index++] = array[i];
            }
        }
        return new Array(positiveElements);
    }

    public int linearSearch(int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean isSorted() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int binarySearch(int element) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == element) {
                return mid;
            } else if (array[mid] < element) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static Array sum(Array arr1, Array arr2) {
        if (arr1.array.length != arr2.array.length) {
            throw new IllegalArgumentException("ALL THE ARRAYS MUST HAVE THE SAME LENGTH");
        }

        int[] newArray = new int[arr1.array.length];
        for (int i = 0; i < arr1.array.length; i++) {
            newArray[i] = arr1.array[i] + arr2.array[i];
        }

        return new Array(newArray);
    }

    public static boolean equals(Array arr1, Array arr2) {
        if (arr1.array.length != arr2.array.length) {
            return false;
        }
        for (int i = 0; i < arr1.array.length; i++) {
            if (arr1.array[i] != arr2.array[i]) {
                return false;
            }
        }
        return true;
    }

    public void cyclicShiftLeft() {
        int temp = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = temp;
    }

    public boolean hasAdjacentZeros() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0 && array[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void shellSort() {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    public void mergeSort() {
        mergeSortHelper(0, array.length - 1);
    }

    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }

    public void quickSort() {
        quickSortHelper(0, array.length - 1);
    }

    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(getElement(i));
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}