package lvl1_lesson7_OOP3;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety=false;
    }

    public void eat(Plate p) {
        if(p.decreaseFood(appetite)) satiety=true;
    }

    public void info()
    {
        System.out.printf("%s сытость = %s\n",name,satiety);
    }
}
