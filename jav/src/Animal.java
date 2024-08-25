// Abstract class: Animal
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void sound();

    public String getName() {
        return name;
    }
}

// Concrete class: Dog (inherits from Animal)
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Woof!");
    }
}

// Concrete class: Cat (inherits from Animal)
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Meow!");
    }
}

// Concrete class: Bird (inherits from Animal)
public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Chirp!");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create objects
        Dog dog = new Dog("Fido");
        Cat cat = new Cat("Whiskers");
        Bird bird = new Bird("Tweety");

        // Polymorphism: call sound() method on each object
        dog.sound(); // Output: Woof!
        cat.sound(); // Output: Meow!
        bird.sound(); // Output: Chirp!

        // Encapsulation: access name property through getter
        System.out.println(dog.getName()); // Output: Fido
        System.out.println(cat.getName()); // Output: Whiskers
        System.out.println(bird.getName()); // Output: Tweety
    }
}
