package lvl3_lesson7_annotations;

public class Test1 {
    public Test1() {
    }

    @BeforeSuite
    public void add() {
        System.out.println("BeforeSuite");
    }

    @Test(priority = 6)
    public void sub() {
        System.out.println("Test 1 priority=6");
    }

    @Test(priority = 2)
    public void mul() {
        System.out.println("Test 2 priority=2");
    }

    @AfterSuite
    public void div() {
        System.out.println("AfterSuite");
    }
}
