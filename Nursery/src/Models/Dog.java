package Models;

public class Dog extends Animal {
    public Dog(String type, String name, String birthday) {
        super(type, name, birthday);
    }

    public Dog(String[] args) {
        super(args);
    }
}
