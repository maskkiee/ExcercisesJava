package Excercises.TASK3;

public class TASK3j {
    static void main() {
        int[] array = {1, 2, 3, 4, 5};
        int temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
        System.out.println(array[0] + " " + array[array.length - 1]);
    }
}
