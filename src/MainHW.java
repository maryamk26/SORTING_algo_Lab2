import java.util.Arrays;
import java.util.Random;

public class MainHW {
    public static void main(String[] args) {
        TheArray a = new TheArray(6);
        a.input();
        a.shellSort();
        System.out.println(a);
        TheArray b = new TheArray(6);
        b.fillRandom(1, 30);
        System.out.println(b);
        b.shellSort();
        System.out.println(b);

        TheArray c = new TheArray(9);
        c.setElement(0, 2);
        c.setElement(1, 8);
        c.setElement(2, 7);
        c.setElement(3, 3);
        c.setElement(4, 9);
        c.setElement(5, 10);
        c.setElement(6, 3);
        c.setElement(7, 5);
        c.setElement(8, -1);
        c.mergeSort();
        System.out.println("mergeSort Array: " + c);
        c.shellSort();
        System.out.println("shellSort Array: " + c);
        c.quickSort();
        System.out.println("quickSort Array: " + c);
    }
}

class TheArray {
    private int[] array;
    private int size;

    public TheArray(int size) {
        this.size = size;
        array = new int[size];
    }

    public void input() {
    }

    public void fillRandom(int min, int max) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
    }

    public void setElement(int index, int value) {
        array[index] = value;
    }

    public void shellSort() {
    }

    public void mergeSort() {
    }

    public void quickSort() {
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
