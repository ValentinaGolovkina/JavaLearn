package lvl3_lesson1_generic;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    private ArrayList<T> fruit = new ArrayList<>();

    public float getWeight(){
        if(fruit.size()==0) return 0;
        return fruit.size()*fruit.get(0).getWeight();
    }

    public boolean compare(Box<?> box){
        return this.getWeight() == box.getWeight();
    }

    public void addAll(Box<T> box){
        fruit.addAll(box.fruit);
        box.fruit.clear();
    }

    public boolean add(T fruit){
        return this.fruit.add(fruit);
    }
}
