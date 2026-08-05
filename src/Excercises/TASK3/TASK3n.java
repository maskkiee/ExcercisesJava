package Excercises.TASK3;

public class TASK3n {
    static void main() {
        int[][] array = {{1,2,3}, {4,5,6}, {7,8,9}};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        System.out.println(sum);
    }
}