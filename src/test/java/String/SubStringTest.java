package String;

import com.s.z.String.StringHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubStringTest {
    @Test
    public void lengthOfLongestSubstringTest(){
        int result = StringHandler.lengthOfLongestSubstring("pwwkew");
        assertTrue(result == 3);
    }

    @Test
    public void lengthOfLongestSubstringTest2(){
        int result = StringHandler.lengthOfLongestSubstring("bpfbhmipx");
        assertTrue(result == 7);
    }

    @Test
    public void lengthOfLongestSubstringTest3(){
        int result = StringHandler.lengthOfLongestSubstring("abba");
        assertTrue(result == 2);
    }
}
