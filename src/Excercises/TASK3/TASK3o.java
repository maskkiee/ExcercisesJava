package Excercises.TASK3;

public class TASK3o {
    static void main() {
        int[][] array = {{1,2}, {3,4}, {5,6}};
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[0].length; j++) {
                sum += array[i][j];
            }
            System.out.println(sum);
        }
    }
}