package Excercises.TASK13;

import java.util.*;
import java.util.function.*;

public class Main {
    static void main() {
        test1();
        test2();
//        test3();
        test4();
        test5();
        test6();
//        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
    }

    private static void test1() {
        System.out.println("Test1");
        Runnable runnable1 = () -> System.out.println("Starting Program");
        Runnable runnable2 = () -> System.out.println("Ending Program");
        runnable1.run();
        runnable2.run();
        System.out.println();
    }

    private static void test2() {
        System.out.println("Test2");
        Function<String, String> trim = String::trim;
        Function<String, String> toLower = String::toLowerCase;
        Function<String, String> replaceAllSpaces = s -> s.replaceAll(" ", "");
        Function<String, String> normalizeLogin = trim
                .andThen(toLower)
                .andThen(replaceAllSpaces);
        String[] loginy = {"  Adam  ", "ANIA K  ", "  k o w a l "};
        for (String login : loginy) {
            System.out.println(normalizeLogin.apply(login));
        }
        System.out.println();
    }

    private static void test3() {
        System.out.println("Test3");
        Function<String, Integer> charAmount = s -> s.replaceAll(" ", "").length();
        Function<String, Integer> vowelAmount = s -> {
            int count = 0;
            for (char c : s.toCharArray()) {
                String lower = s.toLowerCase();
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
                    count++;
                }
            }
            return count;
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();
        System.out.println("Characters in text(no spaces): " + charAmount.apply(text));
        System.out.println("Vowels in text(no spaces): " + vowelAmount.apply(text));
        System.out.println();
    }

    private static void test4() {
        System.out.println("Test4");
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> sub = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> mul = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> div = (a, b) -> a / b;
        int a = 10, b = 3;
        System.out.println(a + " + " + b + " = " + calculate(a, b, add));
        System.out.println(a + " - " + b + " = " + calculate(a, b, sub));
        System.out.println(a + " * " + b + " = " + calculate(a, b, mul));
        System.out.println(a + " / " + b + " = " + calculate(a, b, div));
        System.out.println();
    }

    private static void test5() {
        System.out.println("Test5");
        UnaryOperator<List<Integer>> removeNegatives = list -> {
            list.removeIf(value -> value < 0);
            return list;
        };
        BinaryOperator<Integer> maxOp = (a, b) -> a > b ? a : b;

        List<Integer> nums = new ArrayList<>(Arrays.asList(3, -1, 7, -5, 10, 0));
        System.out.println(removeNegatives.apply(nums));
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            max = maxOp.apply(max, nums.get(i));
        }
        System.out.println("Max: " + max);
        System.out.println();
    }

    private static void test6() {
        System.out.println("Test6");
        String[] loginy = {"adam", "Ala123", "x", "User_01", "ADMIN", "gość"};
        Predicate<String> isValidLogin = (login) ->
        {
            if (login.length() < 3) return false;
            boolean onlyDigitsAndLetters = false;
            if (!Character.isLetter(login.charAt(0))) return false;
            for (char c : login.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    onlyDigitsAndLetters = true;
                } else {
                    return false;
                }
            }
            return onlyDigitsAndLetters;
        };
        for (String login : loginy) {
            if (isValidLogin.test(login)) {
                System.out.println(login);
            }
        }
        System.out.println();
    }

    private static void test7() {
        System.out.println("Test7");
        BiPredicate<String, String> sameIgnoreCase = String::equalsIgnoreCase;
        BiPredicate<String, String> isSuffix = String::endsWith;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text1 = scanner.nextLine();
        System.out.println("Enter text 2: ");
        String text2 = scanner.nextLine();
        check("(ignore case) Is text1 same as text2?", sameIgnoreCase.test(text1, text2));
        check("Is text1 ends with text2?", isSuffix.test(text1, text2));
        System.out.println();
    }

    private static void test8() {
        System.out.println("Test8");
        Consumer<String> logger = System.out::println;
        List<String> lines = Arrays.asList(
                "First line",
                "Second line",
                "Third line",
                "Fourth line"
        );
        printWithNumbers(lines, logger);
        System.out.println();
    }

    private static void test9() {
        System.out.println("Test9");
        Map<String, Integer> productToQty = new HashMap<>();
        productToQty.put("Laptop", 5);
        productToQty.put("Keyboard", 10);
        productToQty.put("Mouse", 15);
        productToQty.put("Monitor", 20);
        BiConsumer<String, Integer> reporter = (name, qty) ->
                System.out.println("Product: " + name + ", Quant: " + qty);
        printReport(productToQty, reporter);
        System.out.println();
    }

    private static void test10() {
        System.out.println("Test10");
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        Supplier<String> codeSupplier = () -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            return sb.toString();
        };
        String[] codes = new String[10];
        for (int i = 0; i < 10; i++) {
            codes[i] = codeSupplier.get();
        }
        System.out.println(Arrays.toString(codes));
        System.out.println();
    }

    private static void test11() {
        System.out.println("Test11");
        StringFormatter toUpper = String::toUpperCase;
        StringFormatter addPrefix = s -> ">>> " + s;
        StringFormatter reverse = s -> new StringBuilder(s).reverse().toString();
        System.out.println(applyFormat("Java", toUpper));
        System.out.println(applyFormat("Java", addPrefix));
        System.out.println(applyFormat("Java", reverse));
        System.out.println();
    }

    private static void test12() {
        System.out.println("Test12");
        TriFunction<Double, Double, Double, Double> weightedAverage = (ocena, waga, maxWaga) -> ocena * waga;
        double[] grades = {3.0, 4.5, 5.0};
        double[] weights = {1.0, 2.0, 3.0};
        double maxWeight = 3.0;
        double sum = 0;
        double sumWeighted = 0;
        for (int i = 0; i < grades.length; i++) {
            double weightedSum = weightedAverage.apply(grades[i], weights[i], maxWeight);
            System.out.println("Grade: " + grades[i] + ", Weight: " + weights[i] + ", Max weight: " + maxWeight + " = " + weightedSum);
            sum += weightedSum;
            sumWeighted += weights[i];
        }
        double wghAverage = sum / sumWeighted;
        System.out.println("Grades sum: " + sum);
        System.out.println("Weights sum: " + sumWeighted);
        System.out.println("Weighted Average: " + wghAverage);
        System.out.println();
    }

    private static void test13() {
        System.out.println("Test13");
        List<Product> products = Arrays.asList(
                new Product("Laptop", 500, 9),
                new Product("Mouse", 20, 6),
                new Product("Keyboard", 20, 7),
                new Product("Monitor", 100, 10)
        );
        products.sort(Comparator.
                comparingDouble((Product p) -> p.price)
                .thenComparing(Comparator.comparingInt((Product p) -> p.rating).reversed()));
        System.out.println(products);
        System.out.println();
    }

    private static void test14() {
        System.out.println("Test14");
        PriceStrategy normal = price -> price;
        PriceStrategy student = price -> price * 0.9;
        PriceStrategy vip = price -> price * 0.8;
        PriceStrategy blackFriday = price -> price * 0.7;
        double[] prices = {100.0, 250.0, 399.0};
        for (double price : prices) {
            System.out.println("Price: " + price + ", normal: " + String.format("%.2f", calculatePrice(price, normal)));
            System.out.println("Price: " + price + ", student: " + String.format("%.2f", calculatePrice(price, student)));
            System.out.println("Price: " + price + ", vip: " + String.format("%.2f", calculatePrice(price, vip)));
            System.out.println("Price: " + price + ", blackFriday: " + String.format("%.2f", calculatePrice(price, blackFriday)));
        }
        System.out.println();
    }

    static double calculatePrice(double basePrice, PriceStrategy strategy) {
        return strategy.apply(basePrice);
    }

    static String applyFormat(String text, StringFormatter formatter) {
        return formatter.format(text);
    }

    static void printReport(Map<String, Integer> map, BiConsumer<String, Integer> consumer) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            consumer.accept(entry.getKey(), entry.getValue());
        }
    }

    static void printWithNumbers(List<String> lines, Consumer<String> consumer) {
        for (int i = 0; i < lines.size(); i++) {
            consumer.accept((i + 1) + ") " + lines.get(i) + ", ");
        }
    }

    static int calculate(int a, int b, BiFunction<Integer, Integer, Integer> op) {
        return op.apply(a, b);
    }

    static void check(String name, boolean condition) {
        if (condition) {
            System.out.println(name + " true");
        } else {
            System.out.println(name + " false");
        }
    }

    @FunctionalInterface
    interface StringFormatter {
        String format(String input);
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    @FunctionalInterface
    interface PriceStrategy {
        double apply(double basePrice);
    }
}