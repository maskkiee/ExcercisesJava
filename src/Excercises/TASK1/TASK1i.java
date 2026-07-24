package Excercises.TASK1;

import java.util.Scanner;

public class TASK1i {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę: ");
        double a = s.nextDouble();
        System.out.println("Podaj drugą liczbę: ");
        double b = s.nextDouble();
        System.out.println("Podaj operator działania(+, -, *, /, %): ");
        String c = s.next();
        if ((c.equals("/") || c.equals("%")) && b == 0) {
            System.out.println("Nie można dzielić przez 0.");
            s.close();
            return;
        }
        double wynik = switch (c) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            case "%" -> a % b;
            default -> throw new IllegalStateException("Nieoczekiwany operator: " + c);
        };

        System.out.println("Wynik: " + wynik);
    }
}
