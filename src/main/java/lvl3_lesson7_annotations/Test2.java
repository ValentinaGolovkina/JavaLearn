package lvl3_lesson7_annotations;

public class Test2 {
    public Test2() {
    }

    @BeforeSuite
    public void add() {
        System.out.println("BeforeSuite");
    }

    @Test
    public void sub() {
        System.out.println("Test 1");
    }

    @AfterSuite
    public void div() {
        System.out.println("AfterSuite");
    }

    @AfterSuite
    public void div2() {
        System.out.println("AfterSuite");
    }
}
