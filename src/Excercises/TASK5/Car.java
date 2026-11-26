package Excercises.TASK5;

public class Car {
    private String brand;
    private int yearOfProduction;

    /*9. **Static field**
    - Add a static field `counter` that counts created `Car` objects.
    - Increase the counter in the constructor.
    - In `main`, print how many objects were created.*/
    public static int counter = 0;

    /*3. *Constructor with parameters**
        - Add a constructor in `Car` that accepts `brand` and `yearOfProduction`.
        - Create several cars with different data and print their values.*/
    public Car(String brand, int yearOfProduction) {
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        counter++;
    }

    public Car(Car car) {
        this.brand = car.brand;
        this.yearOfProduction = car.yearOfProduction;
        counter++;
    }

    /*6. **Calling one constructor from another**
- Add a no-args constructor that calls the parameterized one (`this("Unknown", 2000)`).
- Check in `main`.*/
    public Car() {
        this("Unknown", 2000);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /*5. **Using this in a method**
    - Add a method `changeBrand(String brand)` that changes the object’s `brand` field.
    - Use `this.brand = brand`.
    - Test in `main`.*/
    public void changeBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    /*4. Fields vs local variables**
    - In `Car`, add a method `showDifference()` that creates a local variable named `brand`.
    - Print both values (`this.brand` and local `brand`) to show the difference.*/
    public void showDifference() {
        String brand = "Local Brand";
        System.out.println("Brand: " + brand);
        System.out.println("this.brand = " + this.brand);
        System.out.println();
    }

    public void getCar(Car car) {
        System.out.println("Car info: " + "\nbrand: " + car.getBrand() + " \nyear: " + car.getYearOfProduction());
        System.out.println();
    }

    /*7. **Instance method**
    - Add a method `introduceYourself()` that prints:
      `I am a car of brand BRAND from year YEAR.`
    - Call it in `main` for several objects.*/
    public void introduceYourself() {
        System.out.println("I am a car of brand: " + this.brand + " from year: " + this.yearOfProduction);
        System.out.println();
    }

    /*8. **Static method**
    - Add a static method `classDescription()` that prints:
      `This class represents cars.`
    - Call it in `main` without creating an object.*/
    public static void classDescription() {
        System.out.println("This class represents cars.");
    }

}
