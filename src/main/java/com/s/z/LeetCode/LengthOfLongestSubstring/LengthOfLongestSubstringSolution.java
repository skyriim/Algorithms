package com.s.z.LeetCode.LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class LengthOfLongestSubstringSolution {

/*    public static void main(String[] args){
        String s = "abba";
        System.out.println(s+":"+new LengthOfLongestSubstringSolution().lengthOfLongestSubstring(s));
    }*/


    /**
     * i,j滑动窗口的方式定位子串的起止位置
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int lengthOfS = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int j=0,i=0;j<lengthOfS;j++){
            Character c = s.charAt(j);
            if(map.containsKey(c)){
                i = Math.max(map.get(c)+1,i);
            }
            map.put(c,j);
            result = Math.max(result,j-i+1);
        }
        return result;
    }
    /**
     * 暴力法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s == null){
            return 0;
        }
        if(s.length()<=1){
            return s.length();
        }
        int result =1;
        int lengthOfS=s.length();
        for(int i = 0;i<lengthOfS-1;i++){
            if((lengthOfS-i)<=result){
                break;
            }
            int lengthOfLongestSubStringFromI = lengthOfLongestSubstringFromI(s,i);
            result = lengthOfLongestSubStringFromI>result? lengthOfLongestSubStringFromI:result;
        }
        return result;
    }
    private int lengthOfLongestSubstringFromI(String s,int from){
        int result =-1;
        HashSet<String> set = new HashSet();
        for(int j=from;j<s.length();j++){
            String item =""+ s.charAt(j);
            if(!set.contains(item)){
                set.add(item);
            }else{
                break;
            }
        }
        return set.size();
    }

}
