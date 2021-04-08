package lvl3_lesson6_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Task2Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,4,4,4,4,1}, true},
                {new int[]{4,4},false},
                {new int[]{1,1,1,1},false},
                {new int[]{1,1,2,3},false}
        });
    }

    private Task2 task2;
    private int[] arr;
    private boolean res;

    public Task2Test(int[] arr, boolean res){
        this.arr=arr;
        this.res=res;
    }

    @Before
    public void init() {
        task2 = new Task2();
    }
    @Test
    void checkArr() {
        Assert.assertEquals(res, task2.checkArr(arr));
    }
}