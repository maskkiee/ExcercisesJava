package Excercises.TASK9;

public class Main {
    public static void main(String[] args) {
        zadanie1();
        zadanie2();
        zadanie3();
        zadanie4();
        zadanie5();

    }

    /*Zadanie 1: Walidator hasła (unchecked)

     **Treść:** Napisz klasę `PasswordValidator` z metodą statyczną `validate(String pwd)`, która:

     * rzuca `IllegalArgumentException`, gdy `pwd == null` lub długość `< 8`,
     * rzuca `IllegalArgumentException`, gdy brak co najmniej jednej cyfry,
     * w komunikacie podaje powód (np. `length<8`, `no digit`).*/
    private static void zadanie1() {
        System.out.println("Zadanie 1");
        try {
            PasswordValidator.validate(null);
        } catch (IllegalArgumentException e) {
            System.out.println("null: " + e.getMessage());
        }
        try {
            PasswordValidator.validate("abc");
        } catch (IllegalArgumentException e) {
            System.out.println("short: " + e.getMessage());
        }
        try {
            PasswordValidator.validate("abcdefgh");
        } catch (IllegalArgumentException e) {
            System.out.println("no digit: " + e.getMessage());
        }
        try {
            PasswordValidator.validate("abc12345");
            System.out.println("valid: no exception");
        } catch (IllegalArgumentException e) {
            System.out.println("valid: " + e.getMessage());
        }
        System.out.println();
    }

    /*Zadanie 2: Parser liczby dodatniej (chaining, unchecked)

     **Treść:** Napisz `NumberParser.parsePositiveInt(String s)`:

     * użyj `Integer.parseInt(s)`,
     * jeśli `NumberFormatException` → rzuć własny **unchecked** z komunikatem `Invalid number: '<s>'` i **ustaw cause**,
     * jeśli liczba ≤ 0 → rzuć `IllegalArgumentException("non-positive: " + value)`.*/
    private static void zadanie2() {
        System.out.println("Zadanie 2");
        try {
            NumberParser.parsePositiveInt(null);
        } catch (InvalidNumberException e) {
            System.out.println("null: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getClass().getSimpleName());
        }
        try {
            NumberParser.parsePositiveInt("abc");
        } catch (InvalidNumberException e) {
            System.out.println("no digit: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getClass().getSimpleName());
        }
        try {
            NumberParser.parsePositiveInt("-5");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            int value = NumberParser.parsePositiveInt("5");
            System.out.println("valid: " + value);
        } catch (InvalidNumberException e) {
            System.out.println("valid: " + e.getMessage());
        }
        System.out.println();


    }

    /*Zadanie 3: Konto i wyjątek checked (`throws`)

     **Treść:** Zaprojektuj prostą klasę `BankAccount`:

     * Pole `balance` (int, grosze lub jednostki – jak wolisz).
     * Metoda `withdraw(int amount) throws InsufficientFundsException` – gdy `amount > balance`, rzuć **checked** `InsufficientFundsException` z kontekstem (`balance`, `amount`).
     * W metodzie demonstracyjnej (`main`) obsłuż wyjątek w `catch` i dodaj blok `finally` wypisujący np. `Koniec transakcji`.*/


    private static void zadanie3() {
        System.out.println("Zadanie 3");
        BankAccount bankAccount = new BankAccount(1000);
        try {
            bankAccount.withdraw(1500);
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds: " + e.getMessage());
        } finally {
            System.out.println("End of transaction.");
            System.out.println();
        }
        try {
            bankAccount.withdraw(700);
            System.out.println("Withdraw possible.");
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds: " + e.getMessage());
        } finally {
            System.out.println("End of transaction.");
            System.out.println();
        }
        System.out.println();
    }

    /*Zadanie 4: Multi‑catch i decyzja o reakcji

    **Cel:** Umiejętność łączenia pokrewnych wyjątków.

    **Treść:** Napisz metodę `processCommand(String cmd)`:

    * dla `"ARG"` rzuć `IllegalArgumentException("bad arg")`,
    * dla `"STATE"` rzuć `IllegalStateException("bad state")`,
    * w metodzie `demo()` wywołuj `processCommand` z różnymi wartościami i użyj **multi‑catch**:
    `catch (IllegalArgumentException | IllegalStateException e) { /* wspólna reakcja */
    private static void zadanie4() {
        System.out.println("Zadanie 4");
        CommandProcessor.demo();
        System.out.println();
    }

    /*Zadanie 5: Walidacja adresu e-mail (regex)

     **Treść:** Napisz klasę `EmailValidator` z metodą statyczną `validate(String email)`, która:

     * rzuca **własny, domenowy wyjątek**, gdy `email == null` lub jest pusty/blank,
     * rzuca **własny, domenowy wyjątek**, gdy adres nie pasuje do wzorca poprawnego e-maila (np. brak `@`, brak domeny, brak rozszerzenia po kropce),
     * w komunikacie podaje powód (np. `email is null`, `invalid format: <email>`).

     **Wymagania dot. wyjątków:**

     * Zaprojektuj **własną hierarchię wyjątków domenowych** dla tego problemu — nie używaj gotowego `IllegalArgumentException`.
     * Nazwy klas wyjątków **wymyśl samodzielnie** — dobierz takie, które czytelnie opisują co poszło nie tak (np. osobny przypadek dla pustego/`null` adresu i osobny dla złego formatu). Nazewnictwo jest częścią zadania.
     * Zdecyduj, czy mają być `checked` czy `unchecked`, i uzasadnij wybór krótkim komentarzem w kodzie.*/
    private static void zadanie5() {
        System.out.println("Zadanie 5");
        try {
            EmailValidator.validate(null);
        } catch (EmailIsNull e) {
            System.out.println("null: " + e.getMessage());
        }
        try {
            EmailValidator.validate("abc");
        } catch (InvalidEmailPattern e) {
            System.out.println("Wrong Pattern: " + e.getMessage());
        }
        try {
            EmailValidator.validate("user@example.com");
            System.out.println("valid: no exception");
        } catch (EmailValidationException e) {
            System.out.println("valid: no exception");
        }
        System.out.println();
    }
}