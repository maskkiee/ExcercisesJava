package Excercises.TASK1;

import java.util.Scanner;

public class TASK1l {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj dzień: ");
        int a = s.nextInt();
        System.out.println("Podaj miesiąc: ");
        int b = s.nextInt();
        System.out.println("Podaj rok");
        int c = s.nextInt();

        if (b < 1 || b > 12) {
            System.out.println("Data niepoprawna");
            s.close();
            return;
        }
        boolean ifPrzestepny = (c % 4 == 0);
        int maxDni = switch (b) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> ifPrzestepny ? 29 : 28;
            default -> 0;
        };

        if (a<1 && a <= maxDni) {
            System.out.println("Data poprawna");
        } else {
            System.out.println("Data niepoprawna");
            }
    }
}
