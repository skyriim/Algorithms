package Math;

import com.s.z.Math.Sqrt;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.assertTrue;

import static java.lang.Math.abs;

public class SqrtTest {
    @Test
    public void sqrt1_test1(){
        float value = 9;
        float target = Sqrt.sqrt(value,0.1f);
        assertTrue(abs(target-3)<0.1f);
    }

    @Test
    public void sqrt1_test2(){
        float value = 25;
        float diff = 0.001f;
        float target = Sqrt.sqrt(value,diff);
        assertTrue(abs(target-5)<diff);
    }

    @Test
    public void sqrt2_test1(){
        assertTrue(3==Sqrt.sqrtInt(9));
    }
    @Test
    public void sqrt2_test2(){
        assertTrue(5==Sqrt.sqrtInt(25));
    }
    @Test
    public void sqrt2_test3(){
        assertTrue(4==Sqrt.sqrtInt(16));
    } @Test
    public void sqrt2_test4(){
        assertTrue(1==Sqrt.sqrtInt(3));
    } @Test
    public void sqrt2_test5(){
        assertTrue(2==Sqrt.sqrtInt(8));
    }
}
