package lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 5);
        Cat cat2 = new Cat("Tishka", 4);
        Cat cat3 = new Cat("Garfild", 3);
        Cat[] cats = {cat1, cat2, cat3};
        Plate plate = new Plate(10);
        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
        plate.info();
        plate.increaseFood(10);
        plate.info();
        cat3.eat(plate);
        cat3.info();
        plate.info();
    }
}
