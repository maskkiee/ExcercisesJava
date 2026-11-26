package Excercises.TASK13;

class Product {
    String name;
    double price;
    int rating; // 1–5

    Product(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " (" + price + " PLN, rating=" + rating + ")";
    }
}