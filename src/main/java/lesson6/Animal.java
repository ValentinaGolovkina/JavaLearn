package lesson6;

public class Animal {

    private String name;

    public Animal(String name){
        this.name=name;
    }

    protected void run(int length){
        System.out.println(this.name+" пробежал "+length+" м.");

    }
    protected void  swim(int length){
        System.out.println(this.name+" проплыл "+length+" м.");
    }
}
