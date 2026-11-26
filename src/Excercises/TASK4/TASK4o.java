package Excercises.TASK4;

import java.util.Scanner;

public class TASK4o {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(sumaCyfrIter(n));
    }

    private static int sumaCyfrIter(int n) {
        int sum = 0;
        while (n > 0) {
            int number = n % 10;
            sum += number;
            n = n / 10;
        }
        System.out.println("The sum is " + sum);
        return sum;
    }

}
