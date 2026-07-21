package Excercises.TASK3;

public class TASK3r {
    static void main() {
        int[][] array = {{1,2}, {3,4}, {5,6}};
        int max = 0;
        int secondMax = 0;
        int thirdMax = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int current = array[i][j];
                if (current > max) {
                    thirdMax = secondMax;
                    secondMax = max;
                    max = current;
                    row = i;
                    col = j;
                } else if (current > secondMax && current != max) {
                thirdMax = secondMax;
                secondMax = current;
                } else if (current > thirdMax && current != secondMax && current != max) {
                thirdMax = current;
                }

            }
            }
        System.out.println("max: " + max + " is on position " + row + " " + col);
        System.out.println("third: " + thirdMax);
    }

}
