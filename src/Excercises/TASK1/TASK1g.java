package Excercises.TASK1;

import java.util.Scanner;

public class TASK1g {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj wiek: ");
        int n = s.nextInt();
        String s1 = n > 18 ? "Pełnoletni" : "Niepełnoteni";
        System.out.println(s1);
        }
}
