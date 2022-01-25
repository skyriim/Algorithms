package String;

import com.s.z.String.StringHandler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReverseStringTest {
    private String input = "123456";
    private String output = "654321";
    @Test
    public void reverseStringTest2(){
        char[] result = StringHandler.reversString(input.toCharArray());
        assertTrue(output.equals(String.valueOf(result)));
    }
}
