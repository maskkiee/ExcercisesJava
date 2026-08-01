package Excercises.TASK4;

import java.util.Scanner;

public class TASK4f {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        System.out.println(kategoriaWiekowa(age));
    }

    public static String kategoriaWiekowa(int age) {
        if (age < 12) {
            return "Dziecko";
        } else if (age >= 12 && age < 18) {
            return "Nastolatek";
        } else if (age >= 18 && age < 65) {
            return "Dorosły";
        } else if (age >= 65) {
            return "Senior";
        }
        return "";
    }
}
