package lvl2_lesson3_collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private Map<String, ArrayList<String>> records;

    public Phonebook(){
        records = new HashMap<>();
    }

    public void add(String surname, String phone){
        ArrayList<String> phones = records.getOrDefault(surname,new ArrayList<>());
        phones.add(phone);
        records.put(surname,phones);
    }

    public ArrayList<String> get(String surname){
        return records.get(surname);
    }

    public String toString(){
        return records.toString();
    }

}
