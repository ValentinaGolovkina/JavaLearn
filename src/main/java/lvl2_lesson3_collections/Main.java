package lvl2_lesson3_collections;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] str = {
                "мама",
                "папа",
                "дочь",
                "сын",
                "бабушка",
                "дедушка",
                "мама",
                "папа",
                "дочь",
                "сын",
                "мама",
                "папа",
                "дочь",
                "мама"

        };
        Map<String,Integer> map = new HashMap<>();
        for (String s:str){
            Integer value = map.getOrDefault(s,0);
            map.put(s,value+1);
        }
        System.out.println("Список уникальных слов: "+map.keySet());
        System.out.println("Количество встречания каждого слова: "+map);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров","8-888-888-88-88");
        phonebook.add("Петров","9-999-999-99-99");
        phonebook.add("Курочкин","7-777-777-77-77");
        System.out.println(phonebook);
        System.out.println("Список номеров Петрова: "+phonebook.get("Петров"));

    }
}
