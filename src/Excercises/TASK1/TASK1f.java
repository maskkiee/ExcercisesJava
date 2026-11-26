package Excercises.TASK1;

import java.util.Scanner;

public class TASK1f {
    static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj numer dnia tygodnia: ");
        int n = s.nextInt();
        String dzien = switch (n) {
            case 1 -> "Poniedziałek";
            case 2 -> "Wtorek";
            case 3 -> "Środa";
            case 4 -> "Czwartek";
            case 5 -> "Piątek";
            case 6 -> "Sobota";
            case 7 -> "Niedziela";
            default -> "Nieznany dzień";
        };
        System.out.println(dzien);
     }
}
