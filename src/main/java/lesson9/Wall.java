package lesson9;

public class Wall implements Barrier{
    private int height;
    public Wall(int height){
        this.height=height;
    }

    @Override
    public boolean pass(Member member){
        return member.jump(height);
    }
}
