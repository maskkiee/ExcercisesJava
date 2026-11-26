package Excercises.TASK1;

import java.util.Scanner;

public class TASK1h {
    static void main() {
    Scanner s = new Scanner(System.in);
    System.out.println("Podaj kategorię produktu (żywność, książki, usługi, ubrania, elektronika):");
    String n = s.nextLine();
    String vat = switch (n) {
        case "żywność", "książki" -> "5%";
        case "usługi" -> "8%";
        case "ubrania", "elektronika", "inne" -> "23%";
        default -> "Nie znaleziono kategorii.";
    };
        System.out.println("Stawka VAT wynosi: " + vat);
    }
}
