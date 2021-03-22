package lvl3_lesson1_generic;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {

        // Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        ArrayT<String> arrS = new ArrayT<>(new String[]{"qwe", "asd", "zxc"});
        System.out.println(arrS.changeTwoItems(1,2));
        ArrayT<Integer> arrI = new ArrayT<>(new Integer[]{1, 2, 3});
        System.out.println(arrI.changeTwoItems(0,2));

        //2. Написать метод, который преобразует массив в ArrayList;
        ArrayList<String> arrList =  new ArrayT<String>().asList(new String[]{"qwe", "asd", "zxc"});
        System.out.println(arrList);

//        3. Большая задача:
//        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//        g. Не забываем про метод добавления фрукта в коробку.

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        System.out.printf("Вес коробки яблок: %s \nВес коробки апельсин: %s \nКоробки равны: %s \n"
                ,appleBox.getWeight()
                ,orangeBox.getWeight()
                ,appleBox.compare(orangeBox)
        );

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addAll(appleBox);
        System.out.printf("Вес коробки яблок 1: %s \nВес коробки яблок 2: %s\n"
                ,appleBox.getWeight()
                ,appleBox2.getWeight()
        );
    }
}
