package com.s.z.LeetCode.NumberValidate;

import java.util.HashSet;

public class IsHappyNumber {
    public boolean isHappy(int n) {
        HashSet seen = new HashSet<Integer>();
        int result = n;
        while(true){
            result = getNext(result);
            if(result!= 1){
                if(seen.contains(result)){
                    return false;
                }else{
                    seen.add(result);
                }
            }else{
                return true;
            }
        }
    }

    private int getNext(int n){
        int result=0;
        String valStr = n+"";
        for(int i=0;i<valStr.length();i++){
            int numAtI = Integer.parseInt(valStr.charAt(i)+"");
            result = result + (int)Math.pow(numAtI,2);
        }
        return result;
    }

    /*public static void main(String args[]){
        System.out.print(new IsHappyNumber().isHappy(19));
    }*/
}
