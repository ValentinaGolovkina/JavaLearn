package lvl2_lesson1_OOP;

public class Treadmill implements Barrier{
    private int length;
    public Treadmill(int length){
        this.length=length;
    }
    @Override
    public boolean pass(Member member){
        return member.run(length);
    }
}
