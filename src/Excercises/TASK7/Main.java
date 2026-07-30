package Excercises.TASK7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    static void main() {
        zadanie1();
        zadanie2();
        zadanie3();
        zadanie4();
        zadanie5();
        zadanie6();
        zadanie7();
        zadanie8();
        zadanie9();
        zadanie10();
        zadanie11();
        zadanie12();
        zadanie13();
        zadanie14();
        zadanie15();
        zadanie16();
        zadanie17();
        zadanie18();
        zadanie19();
        zadanie20();
    }

    /*1. **Simple use of BigDecimal**
    - Create a BigDecimal object with value 10.50 and print it to the console.
    - Create another object with value 2.25 and print the sum, difference, product, and quotient.*/
    static void zadanie1() {
        System.out.println("Zadanie 1:");
        BigDecimal first = new BigDecimal("10.50");
        BigDecimal second = new BigDecimal("2.25");
        System.out.println("First: " + first);
        System.out.println("Second: " + second);
        System.out.println("Sum: " + first.add(second));
        System.out.println("Difference: " + first.subtract(second));
        System.out.println("Product: " + first.multiply(second));
        System.out.println("Quotient: " + first.divide(second, 2, RoundingMode.HALF_UP));
        System.out.println();
    }

    /*2. **BigDecimal from String**
        - Create a BigDecimal by passing the value as a String and as a double.
        - Print both values to show the difference in precision.*/
    static void zadanie2() {
        System.out.println("Zadanie 2:");
        BigDecimal fromString = new BigDecimal("0.1");
        BigDecimal fromDouble = new BigDecimal(0.1);

        System.out.println("From String: " + fromString);
        System.out.println("From double: " + fromDouble);
        System.out.println();
    }

    /*3. **Rounding prices**
        - Create a BigDecimal with value 10.56789.
        - Round it to two decimal places using setScale(2, RoundingMode.HALF_UP).
        - Print the result.*/
    static void zadanie3() {
        System.out.println("Zadanie 3:");
        BigDecimal first = new BigDecimal("10.56789");
        System.out.println("10.56789 ~ " + first.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println();
    }

    /*4. **Calculating discount**
        - Read a price (BigDecimal) and a discount percentage (BigDecimal).
        - Calculate the price after discount, rounding to two decimal places.*/
    static void zadanie4() {
        System.out.println("Zadanie 4:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter price: ");
        BigDecimal price = scanner.nextBigDecimal();

        System.out.println("Enter discount percentage: ");
        BigDecimal discount = scanner.nextBigDecimal();

        BigDecimal discountAmount = price.multiply(discount).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        BigDecimal finalPrice = price.subtract(discountAmount);
        System.out.println("Price after discount: " + finalPrice);
        System.out.println();
    }

    /*5. **VAT tax**
        - Read net price (BigDecimal).
        - Add 23% VAT and print the gross price rounded to two decimal places.*/
    static void zadanie5() {
        System.out.println("Zadanie 5:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price: ");
        BigDecimal netPrice = scanner.nextBigDecimal();
        BigDecimal VAT = new BigDecimal("0.23");
        System.out.println("Net Price: " + netPrice);
        System.out.println("VAT: " + VAT);
        BigDecimal VATAmount = netPrice.multiply(VAT);
        System.out.println("Final Price : " + netPrice.add(VATAmount));
        System.out.println();
    }

    /*6. **Comparing prices**
        - Read two prices (BigDecimal).
        - Check which one is greater using compareTo() and print the proper message.*/
    static void zadanie6() {
        System.out.println("Zadanie 6:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter price 1: ");
        BigDecimal price1 = scanner.nextBigDecimal();

        System.out.println("Enter price 2: ");
        BigDecimal price2 = scanner.nextBigDecimal();
        int isGreater = price1.compareTo(price2);
        if (isGreater > 0) {
            System.out.println("Price 1 is greater than price 2");
        } else if (isGreater < 0) {
            System.out.println("Price 2 is less than price 1");
        } else {
            System.out.println("Prices are equal");
        }
        System.out.println();
    }

    /*7. **Shopping cart sum**
        - Create an array of BigDecimal with several product prices.
        - Calculate the total cart value with precision to two decimal places.*/
    static void zadanie7() {
        System.out.println("Zadanie 7:");
        BigDecimal[] prices = {
                new BigDecimal("19.99"),
                new BigDecimal("5.50"),
                new BigDecimal("12.75"),
                new BigDecimal("3.25"),
                new BigDecimal("8.99")
        };
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal price : prices) {
            total = total.add(price);
        }
        System.out.println("Total : " + total.setScale(2, RoundingMode.HALF_UP));
        System.out.println();
    }

    /*8. **Average price**
        - Read from user the number of products and their prices (BigDecimal).
        - Calculate the average price rounded to two decimal places.*/
    static void zadanie8() {
        System.out.println("Zadanie 8:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of products: ");
        int count = scanner.nextInt();

        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < count; i++) {
            System.out.println("Enter price " + (i + 1) + ": ");
            total = total.add(scanner.nextBigDecimal());
        }

        BigDecimal average = total.divide(new BigDecimal(count).setScale(2));
        System.out.println("Average price: " + average);
        System.out.println();
    }

    /*9. **Prices in different currencies**
        - Read a price in PLN (BigDecimal) and the exchange rate to EUR (BigDecimal).
        - Convert the price to EUR and round to two decimal places.*/
    static void zadanie9() {
        System.out.println("Zadanie 9:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Price in PLN: ");
        int PLN = scanner.nextInt();
        double exchangeRate = 4.3;
        System.out.println(PLN + " PLN is " + (exchangeRate * PLN) + " Euro");
        System.out.println();
    }

    /*10. **Precision difference - double vs BigDecimal**
        - Calculate 0.1 + 0.2 using double and print the result.
        - Do the same with BigDecimal (constructor with String) and print the result.
        - Compare the differences.*/
    static void zadanie10() {
        System.out.println("Zadanie 10:");
        double sum = 0.1 + 0.2;
        System.out.println("In double: " + sum);
        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("0.2");
        BigDecimal sum2 = num1.add(num2);
        System.out.println("In BigDecimal: " + sum2);
        System.out.println();
    }

    /*11. **String - basic operations**
        - Read text from user.
        - Print its length, uppercase version, lowercase version, and reversed text (last character first).*/
    static void zadanie11() {
        System.out.println("Zadanie 11:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();
        System.out.println("Length: " + text.length());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Reversed: " + new StringBuilder(text).reverse());
        System.out.println();
    }

    /*12. **String - searching**
        - Read a sentence and a word.
        - Check if the word occurs in the sentence (contains()), and at what position (indexOf()).*/
    static void zadanie12() {
        System.out.println("Zadanie 12:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sentence: ");
        String sentence = scanner.nextLine();
        System.out.println("Enter word: ");
        String word = scanner.nextLine();
        sentence = sentence.toLowerCase();
        word = word.toLowerCase();
        if (sentence.contains(word)) {
            System.out.println("Sentence contains word at position: " + sentence.indexOf(word));
        } else  {
            System.out.println("Sentence does not contain word.");
        }
        System.out.println();
    }

    /*13. **String - replacing fragments**
        - Read a sentence and replace all spaces with _.
        - Then remove all commas.*/
    static void zadanie13() {
        System.out.println("Zadanie 13:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();
        text = text.replace(" ", "_");
        System.out.println("New text: " + text);
        text = text.replace(".", "");
        System.out.println("Without commaas: " + text);
        System.out.println();
    }

    /*14. **String - comparison**
        - Read two strings.
        - Check equality using equals() and equalsIgnoreCase().
        - Print results.*/
    static void zadanie14() {
        System.out.println("Zadanie 14:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text 1: ");
        String text1 = scanner.nextLine();
        System.out.println("Enter text 2: ");
        String text2 = scanner.nextLine();
        System.out.println("Check with equals: " + text1.equals(text2));
        System.out.println("Check with equals: " + text1.equalsIgnoreCase(text2));
        scanner.close();
    }

    /*15. **String - splitting text**
        - Read a sentence containing multiple words separated by spaces.
        - Split it with split(" ") and print each word on a new line.*/
    static void zadanie15() {
        System.out.println("Zadanie 15:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sentence(multiple words separated by spaces): ");
        String text = scanner.nextLine();
        String[] words = text.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println();
    }

    /*16. **String - checking prefix and suffix**
        - Read text from user.
        - Check if it starts with "Java" and if it ends with "2025".*/
    static void zadanie16() {
        System.out.println("Zadanie 16:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sentence: ");
        String text = scanner.nextLine();
        System.out.println("Does start with Java? " + text.startsWith("Java"));
        System.out.println("Does end with 2025? " + text.endsWith("2025"));
        System.out.println();
    }

    /*17. **Combining BigDecimal and String**
        - Read product name (String) and its price (BigDecimal).
        - Print: Product: NAME, price: XX.XX PLN.*/
    static void zadanie17() {
        System.out.println("Zadanie 17:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.println("Product: " + name + ", price: " + price.setScale(2, RoundingMode.HALF_UP) + " PLN");
        System.out.println();
    }

    /*18. **Formatting prices**
        - Read a list of prices (BigDecimal) and print them in format XX.XX zl (always two decimals, even .00).*/
    static void zadanie18() {
        System.out.println("Zadanie 18:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many prices you want to add?");
        int count = scanner.nextInt();
        for (int i = 0; i < count ; i++) {
            System.out.println("Enter price " + (i + 1) + ": ");
            BigDecimal price = scanner.nextBigDecimal();
            System.out.println(price.setScale(2, RoundingMode.HALF_UP) + " zl");
        }
        System.out.println();
    }

    /*19. **Splitting a bill**
        - Read total bill amount (BigDecimal) and number of people (int).
        - Split equally and print how much each pays (always two decimals).*/
    static void zadanie19() {
        System.out.println("Zadanie 19:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bill amount: ");
        BigDecimal billAmount = scanner.nextBigDecimal();
        System.out.println("Enter the number of people");
        int count = scanner.nextInt();
        System.out.println("Each person pays:" + billAmount.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP));
        System.out.println();
    }

    /*20. **Rounding up**
        - Read a price (BigDecimal).
        - Round it up to full grosz (RoundingMode.CEILING) and print result.*/
    static void zadanie20() {
        System.out.println("Zadanie 20:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price: ");
        BigDecimal price = scanner.nextBigDecimal();
        System.out.println("Rounded up: " + price.setScale(2, RoundingMode.CEILING));
    }
}