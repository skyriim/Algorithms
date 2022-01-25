package com.s.z.String;

import java.util.HashMap;
import java.util.HashSet;

public class StringHandler {

    /**
     * 不使用额外数组的情况下反转
     * @param s
     * @return
     */
    public static char[] reversString(char[] s) {
        char temp;
        for (int i = s.length - 1, j = 0; i > j; ) {
            temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i--;
            j++;
        }
        return s;
    }

    /**给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<String,Integer> lastAppearanceMap = new HashMap<String,Integer>();
        //i 、 j 作为边界index
        int i=0,j=0,windowLength=0,maxLength = 0;
        while(j<s.length()){
            String cs = String.valueOf(s.charAt(j));
            //通过map和窗口左边界index，判断当前字符是否在窗口内有重复
            if(lastAppearanceMap.containsKey(cs) && lastAppearanceMap.get(cs)>=i){
                i = lastAppearanceMap.get(cs)+1;
            }
            lastAppearanceMap.put(cs,j);
            windowLength = j-i+1;
            maxLength = windowLength>maxLength?windowLength:maxLength;
            j++;
        }
        return maxLength;
    }

}
