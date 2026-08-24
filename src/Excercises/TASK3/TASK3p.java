package Excercises.TASK3;

public class TASK3p {
    static void main() {
        int[][] array = {{1,2}, {3,4}, {5,6}};
        for (int i = 0; i < array[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum += array[j][i];
            }
            System.out.println(sum);
        }
    }
}