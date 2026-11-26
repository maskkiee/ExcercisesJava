package Excercises.TASK5;

public class Person {
    private String name;
    private int age;

    /*15. **Static vs non-static – difference**
    - In `Person`, add a static field `numberOfPeople`.
    - Increase it in the constructor.
    - In `main`, print how many objects were created and compare access via object vs class.
    */
    public static int numberOfPeople = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfPeople++;
    }

    /*13. **Constructor overloading – Person**
    - Add a constructor with two parameters (`name`, `age`) and another with only `name` (default age = 0).
    - Create objects using different constructors and print data.
    14. **Using this in overloaded constructors**
    - In the one-parameter constructor (`name`), call the two-parameter constructor with `age = 0`.
    - Test in `main`.*/
    public Person(String name) {
        this(name, 0);
    }

    /*11. **Simple class Person**
                - Create a class `Person` with fields `name` and `age`.
                - Add a method `introduceYourself()` that prints the person’s data.
                - In `main`, create several people and call their methods.*/
    public void introduceYourself() {
        System.out.println("I'm " + this.name + " and I'm " + this.age);
        System.out.println();
    }

    /*12. **Method overloading – Person**
    - In `Person`, add an overloaded method `introduceYourself(String greeting)` that prints the greeting before the person’s info.
    - Call both versions in `main`.*/
    public void introduceYourself(String greeting) {
        System.out.println(greeting + "\nI'm " + this.name + " and I'm " + this.age + " years old.");
        System.out.println();
    }

    /*16. **Array of people and method**
    - Create an array `Person[]` with several objects.
    - Add a method in `Person` that returns whether the person is an adult.
    - In `main`, print which people are adults.*/
    public void isAdult() {
        if (this.age >= 18) {
            System.out.println(this.name + " is an adult.");
        } else {
            System.out.println(this.name + " isn't adult.");
        }
        System.out.println();
    }

    /*17. **Method with object parameter**
    - Add a method `compareAge(Person other)` that returns the age difference.
    - In `main`, compare the age of two people and print the result.*/
    public void compareAge(Person other) {
        if (this.age > other.age) {
            System.out.println(this.name + " is older than " + other.name);
        } else if (this.age < other.age) {
            System.out.println(other.name + " is older than " + this.name);
        } else {
            System.out.println(this.name + " is as old as " + other.name);
        }
        System.out.println();
    }

}
