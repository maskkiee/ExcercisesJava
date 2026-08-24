package Excercises.TASK5;

public class Shop {
    String name;
    Product[] product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    public Shop() {
    }

    public Shop(String name, Product[] product) {
        this.name = name;
        this.product = product;
    }

    public void showProducts() {
        for (Product p : product) {
            System.out.println(p.getName() + " " + p.getPrice());
        }
    }
}
