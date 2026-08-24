package Excercises.TASK2;

import java.util.Scanner;

public class TASK2e {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Wczytaj napis:");
        String n = s.next();
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == 'a') {
                System.out.println("Litera a znajduje się na miejscu: " + n.length());
            }
        }
    }
}
