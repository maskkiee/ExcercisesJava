package Excercises.TASK2;

import java.util.Scanner;

public class TASK2m {
    public static void main() {
        Scanner s = new Scanner(System.in);
        String popLogin = "java123";
        String popHaslo = "java321";
        boolean czyZalogowano = false;
        for (int i = 1; i <= 3; i++) {
            System.out.println("Próba " + i + " z 3");
            System.out.print("Podaj login: ");
            String login = s.next();
            System.out.print("Podaj hasło: ");
            String haslo = s.next();
        if (login.equals(popLogin) && haslo.equals(popHaslo)) {
            System.out.println("Zalogowano pomyslnie!");
            czyZalogowano = true;
            break;
            } else {
            System.out.println("Błędne dane.");
            }

            }
        if (!czyZalogowano) {
            System.out.println("Konto Zablokowane");
            }
    }
}