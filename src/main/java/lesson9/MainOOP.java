package lesson9;

public class MainOOP {
    public static void main(String[] args) {
        Member[] members = {
                new Cat("Васька"),
                new Person("Петя"),
                new Robot("Arno")
        };

        Barrier[] barriers = {
                new Treadmill(7),
                new Wall(3)
        };

        for (Member m:members)
            for(Barrier b: barriers)
                if(!b.pass(m)) break;

    }
}
