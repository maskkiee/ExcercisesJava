package Excercises.TASK4;

import java.util.Scanner;

public class TASK4t {
    static void main() {
        menu(5, 10);

    }
    private static void menu(int a, int b){
        System.out.println("What do you want to do? 1 - add, 2 - subtract, 3 - multiply, 0 - quit.");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(dodaj(a, b));
        } else if (n == 2) {
            System.out.println(odejmij(a, b));
        }
        else if (n == 3) {
            System.out.println(pomnoz(a, b));
        }
        else if (n == 0) {
            System.out.println("End of menu.");
        }
    }

    private static int dodaj(int a, int b) {
        return a + b;
    }

    private static int odejmij(int a, int b) {
        return a - b;
    }

    private static int pomnoz(int a, int b) {
        return a * b;
    }
}
