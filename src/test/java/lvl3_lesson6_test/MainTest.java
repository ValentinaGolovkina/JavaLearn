package lvl3_lesson6_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MainTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1,7}},
                {new int[]{2,2,3,4},new int[]{}},
                {new int[]{2,2},new int[]{}}
        });
    }

    private Main main;
    private int[] arr;
    private int[] res;

    public MainTest(int[] arr, int[] res){
        this.arr=arr;
        this.res=res;
    }

    @Before
    public void init() {
        main = new Main();
    }
    @Test
    public void getItemsAfter4() {
        Assert.assertArrayEquals(res, main.getItemsAfter4(arr));
    }
}