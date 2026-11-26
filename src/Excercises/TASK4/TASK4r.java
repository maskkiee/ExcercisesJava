package Excercises.TASK4;

import java.util.Scanner;

public class TASK4r {
    static void main() {
        System.out.println("NWD 20, 30 = " + nwdIter(20, 30));
        System.out.println("NWD 17, 3 = " + nwdIter(17, 3));
        System.out.println("NWD 18, 84 = " + nwdIter(18, 54));
    }

    public static int nwdIter(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
