package lvl3_lesson1_generic;

import java.util.ArrayList;

public class ArrayT<T> {

    private T[] items;

    public ArrayT() { }

    public ArrayT(T[] items) {
        this.items=items;
    }

    public ArrayT<T> changeTwoItems(int i, int j){
        T tmp = items[i];
        items[i]=items[j];
        items[j]=tmp;
        return this;
    }

    public ArrayList<T> asList(T[] items){
        ArrayList<T> list = new ArrayList<>(items.length);
        for (T item : items) {
            list.add(item);
        }
        return list;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(T item : items){
            sb.append(item.toString());
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
