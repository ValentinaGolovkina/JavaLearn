package lvl1_lesson6_OOP2;

public class Cat extends Animal{
    static int count;
    public Cat(String name)
    {
        super(name);
        Cat.count++;
    }

    @Override
    public void run(int length){
        if(length<200) super.run(length);
		else System.out.println("Кот не может пробежать больше 200м.");

    }
    @Override
    public void swim(int length){
        System.out.println("Кот не умеет плавать");
    }
}
