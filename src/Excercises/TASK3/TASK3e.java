package Excercises.TASK3;

public class TASK3e {
    public static void main() {
        int[] array = {1,5,7,9,10};
        double sum = 0;
        double average = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
            average = sum/array.length;
        }
        System.out.println(average);
    }
}
