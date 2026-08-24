package Excercises.TASK1;

import java.util.Scanner;

public class TASK1c {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj wiek: ");
        int n = s.nextInt();
        if (n < 0) {
            System.out.println("Nie może być ujemny.");
        } else if (n < 12) {
            System.out.println("Dziecko.");
        } else if (n <= 17)
            System.out.println("Nastolatek.");
        else if (n < 64)
            System.out.println("Dorosły.");
        else
            System.out.println("Senior.");

}
}