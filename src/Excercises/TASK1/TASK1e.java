package Excercises.TASK1;

import java.util.Scanner;

public class TASK1e {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj numer dnia tygodnia: ");
        int n = s.nextInt();
        if (n < 0 || n > 7) {
            System.out.println("Nie ma takiego dnia.");
        } else {
            switch (n) {
                case 1:
                    System.out.println("Poniedziałek");
                    break;
                case 2:
                    System.out.println("Wtorek");
                    break;
                case 3:
                    System.out.println("Środa");
                    break;
                case 4:
                    System.out.println("Czwartek");
                    break;
                case 5:
                    System.out.println("Piątek");
                    break;
                case 6:
                    System.out.println("Sobota");
                    break;
                case 7:
                    System.out.println("Niedziela");
                    break;
                default:
                    System.out.println("Nieznany dzień");
                    break;
            }
        }
        }
}
