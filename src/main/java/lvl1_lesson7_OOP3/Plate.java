package lvl1_lesson7_OOP3;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if(n>food) return false;
        food -= n;
        return true;
    }

    public void increaseFood(int n){
        food+=n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
