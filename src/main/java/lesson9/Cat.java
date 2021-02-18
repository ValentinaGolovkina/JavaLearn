package lesson9;

public class Cat implements Member{
    private String name;
    private int maxHeight=4;
    private int maxLength=5;

    public Cat(String name){
        this.name=name;
    }

    @Override
    public boolean jump(int height) {
        if(height<=maxHeight){
            System.out.println(name+" успешно прыгнул "+height+ " метров.");
            return true;
        }
        else {
            System.out.println(name+" не смог прыгнуть "+height+ " метров.");
            return false;
        }
    }

    @Override
    public boolean run(int length) {
        if(length<=maxLength) {
            System.out.println(name + " пробежал " + length + " метров.");
            return true;
        }
        else {
            System.out.println(name+" не смог пробежать "+length+ " метров.");
            return false;
        }
    }
}
