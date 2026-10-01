package Excercises.TASK5;

public class Product {
    String name;
    double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /*18. **Simple class Product**
    - Create a class `Product` with fields `name` and `price` (Double, or BigDecimal if you know it).
    - Add a constructor and a method `showProduct()` that prints product data.
    - In `main`, create several products and print them.
    */
    public void showProduct() {
        System.out.println(this.name);
        System.out.println(this.price + "$");
        System.out.println();
    }

    /*19. **Overloaded methods in Product**
    - In `Product`, add a method `reducePrice(Double amount)` and an overloaded version `reducePrice(Double amount, String reason)` that also prints the reason.
    - Test both methods in `main`.
    */
    public void reducePrice(double amount) {
        this.price -= amount;
        System.out.println("Price is reduced by " + amount + " and now costs: " + this.price);
        System.out.println();
    }

    public void reducePrice(Double amount, String reason){
        this.price -= amount;
        System.out.println("Price is reduced by " + amount + " and now costs: " + this.price + " because: " + reason);
        System.out.println();
    }
}
