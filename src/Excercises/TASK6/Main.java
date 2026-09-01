package Excercises.TASK6;

import java.io.PrintStream;
import java.util.Scanner;

import static Excercises.TASK6.MenuOption.START;
import static Excercises.TASK6.MenuOption.STOP;
import static Excercises.TASK6.MenuOption.EXIT;

public class Main {
    static void main() {

        /*1. Prosty enum – dni tygodnia**
         - Utwórz `enum DayOfWeek` z wartościami: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY.
         - W `main` przypisz zmiennej dowolny dzień i wypisz go.*/
        DayOfWeek day1 = DayOfWeek.MONDAY;
        System.out.println(day1);
        System.out.println();

        /*2. **Enum i pętla**
        - Użyj pętli `for-each` do wypisania wszystkich dni tygodnia z `DayOfWeek.values()`.*/
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }
        System.out.println();

        /*3. **Porównywanie enum**
        - Utwórz dwie zmienne typu `DayOfWeek`.
        - Porównaj je operatorem `==` i wypisz wynik.*/
        DayOfWeek day2 = DayOfWeek.TUESDAY;
        DayOfWeek day3 = DayOfWeek.WEDNESDAY;
        System.out.println(day2 == day3);
        System.out.println();

        /*4. **Enum w switch**
        - Wykorzystaj `switch` na `DayOfWeek`, aby wypisać komunikat:
        `Początek tygodnia`, `Środek tygodnia`, `Weekend`.*/

        switch (day3) {
            case MONDAY:
            case TUESDAY:
                System.out.println("Poczatek tygodnia");
                break;
            case WEDNESDAY:
            case THURSDAY:
                System.out.println("Srodek tygodnia");
                break;
            case FRIDAY:
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend");
                break;
        }
        System.out.println();

        /*5. **Enum z metodą**
    - Dodaj w `DayOfWeek` metodę `isWeekend()`, która zwraca `true` dla SATURDAY i SUNDAY.
    - W `main` sprawdź działanie dla kilku dni.*/
        DayOfWeek day4 = DayOfWeek.SATURDAY;

        System.out.println("Dzień: " + day3 + "\nCzy weekend? " + day3.isWeekend());
        System.out.println("Dzień: " + day4 + "\nCzy weekend? " + day4.isWeekend());

        /*Zadania od 6 do 9*/
        for (Month month : Month.values()) {
            System.out.println((month.ordinal() + 1) + " " + month + " SEZON WAKACYJNY? " + month.isHolidaySeason());
        }
        System.out.println();

        /*10. **Enum w klasie – osoba i dzień wolny**
    - Utwórz klasę `Person` z polami `name` (String) i `dayOff` (DayOfWeek).
    - Dodaj metodę `showDayOff()`.
    - W `main` utwórz kilka osób i wypisz, jaki mają dzień wolny.*/
        for (Person person : Person.values()) {
            System.out.println(person);
        }
        System.out.println();

        /*11. **Enum w tablicy**
    - Utwórz tablicę przechowującą kilka wartości `Month`.
    - Wypisz je w pętli i sprawdź, ile łącznie mają dni.*/
        Month[] months = Month.values();
        for (Month month : months) {
            System.out.println(month);
        }
        System.out.println();

        /*12. **Enum – waluta**
        - Utwórz `enum Currency` z wartościami PLN, USD, EUR.
        - Dodaj pole `symbol` (String), np. "zł", "$", "€".
        - Dodaj metodę `getSymbol()`.
        - W `main` wypisz wszystkie waluty i ich symbole.*/
        Currency[] currencies = Currency.values();
        for (Currency currency : currencies) {
            System.out.println(currency + " (" + currency.getSymbol() + ")");
        }
        System.out.println();

        /*13. Enum w kalkulatorze**
         - Utwórz `enum Operation` z wartościami ADD, SUBTRACT, MULTIPLY, DIVIDE.
         - Dodaj metodę `calculate(int a, int b)` wykonującą działanie.
         - W `main` przetestuj wszystkie operacje.*/
        Operation[] operations = Operation.values();
        for (Operation operation : operations) {
            System.out.println(operation.name() + " " + operation.calculate(5, 10));
        }
        System.out.println();

        /*14. **Enum – status zamówienia**
        - Utwórz `enum OrderStatus` z wartościami: NEW, PROCESSING, SHIPPED, DELIVERED, CANCELED.
        - Dodaj metodę `isActive()`, która zwraca `true` dla statusów poza CANCELED i DELIVERED.
        - W `main` przetestuj dla kilku statusów.*/
        OrderStatus orderStatus = OrderStatus.values()[0];
        for (OrderStatus order : OrderStatus.values()) {
            System.out.println(order + " is Active? " + order.isActive());
        }
        System.out.println();

        /*15. **Enum i konstruktory przeciążone**
        - Utwórz `enum Planet` z polami `mass` i `radius`.
        - Dodaj konstruktor ustawiający oba pola.
        - Dodaj metodę `getDensity()`, która oblicza gęstość.
        - Wypisz dane wszystkich planet.*/
        Planet[] planets = Planet.values();
        for (Planet planet : Planet.values()) {
            System.out.println(planet + "'s mass is: " + planet.getMass() + " (×10²⁴ kg). Radius: " + planet.getRadius() + " (km) Density: " + planet.getDensity());
        }
        System.out.println();

        /*16. **Enum jako singleton**
        - Utwórz `enum Logger` z jedną wartością `INSTANCE`.
        - Dodaj metodę `log(String msg)`, która wypisuje komunikat na konsoli.
        - W `main` użyj `Logger.INSTANCE.log("test")`.*/
        Logger.INSTANCE.log("test");
        System.out.println();

        /*17. Enum i switch – menu**
         - Utwórz `enum MenuOption` z wartościami: START, STOP, EXIT.
         - W `main` obsłuż wybór użytkownika (switch na `MenuOption`).*/
        MenuOption[] options = new MenuOption[]{MenuOption.START, MenuOption.STOP, MenuOption.EXIT};
        for (MenuOption menuOption : options) {
            switch (menuOption) {
                case START -> System.out.println("Starting program...");
                case STOP -> System.out.println("Stopping program...");
                case EXIT -> System.out.println("Exiting program...");
            }
        }
        System.out.println();

        /*18. **Enum i tablica obiektów**
        - Utwórz klasę `Product` z polami `name` i `category` (enum `Category`).
        - Enum `Category` powinien mieć wartości: FOOD, ELECTRONICS, CLOTHING.
        - W `main` utwórz tablicę produktów i wypisz ich dane.*/
        Product[] products = new Product[]{
                new Product("Chleb", Category.FOOD),
                new Product("Laptop", Category.ELECTRONICS)};
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println();

        /*19. **Enum z metodą abstrakcyjną**
                - Utwórz `enum Calculation` z wartościami ADD, SUBTRACT, MULTIPLY, DIVIDE.
                - Zdefiniuj w nim metodę abstrakcyjną `calculate(int a, int b)` i zaimplementuj ją w każdej wartości.
        - W `main` wykonaj wszystkie działania.*/
        for(Calculation calculation : Calculation.values()) {
            System.out.println(calculation.name() + " " + calculation.calculate(5, 10));
        }
        System.out.println();

        /*20. **Enum i equals vs ==**
        - Utwórz dwie zmienne wskazujące na ten sam element `enum`.
        - Porównaj je operatorem `==` oraz metodą `equals()`.
        - Wypisz wyniki, aby pokazać, że w przypadku `enum` działają tak samo.*/
        DayOfWeek day6 = DayOfWeek.SATURDAY;
        DayOfWeek day7 = DayOfWeek.SATURDAY;
        System.out.println("'==' comparsion: ");
        System.out.println(day6 == day7);
        System.out.println("equals() comparsion: ");
        System.out.println(day6.equals(day7));
    }
}
