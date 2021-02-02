package lesson6;

public class AppAnimals {
    public static void main(String[] args) {
        Animal animal = new Animal("Животное");
        animal.run(5);
        animal.swim(2);
        Animal cat = new Cat("Барсик");
        cat.run(40);
        cat.run(250);
        cat.swim(3);
        Animal dog = new Dog("Джордж");
        dog.run(20);
        dog.run(555);
        dog.swim(3);
        dog.swim(11);
        Dog dog2 = new Dog("Шарик");
        System.out.println("Создано котов: "+ Cat.count);
        System.out.println("Создано собак: "+ Dog.count);
    }
}
