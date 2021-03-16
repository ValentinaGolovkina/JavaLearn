package lvl1_lesson6_OOP2;

public class Dog extends Animal{
    static int count;
    public Dog(String name)
    {
        super(name);
        Dog.count++;
    }

    @Override
    public void run(int length){
        if(length<500) super.run(length);
		else System.out.println("Собака не может пробежать больше 500м.");

    }
    @Override
    public void swim(int length){
        if(length<10) super.swim(length);
		else System.out.println("Собака не может проплыть больше 10м.");
    }
}
