package lvl3_lesson7_annotations;

public class Test3 {
    public Test3() {
    }

    @BeforeSuite
    public void add() {
        System.out.println("BeforeSuite");
    }

    @BeforeSuite
    public void add2() {
        System.out.println("BeforeSuite");
    }

    @Test
    public void mul() {
        System.out.println("Test 2");
    }

    @AfterSuite
    public void div() {
        System.out.println("AfterSuite");
    }
}
