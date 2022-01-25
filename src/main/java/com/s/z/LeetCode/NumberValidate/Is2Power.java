package com.s.z.LeetCode.NumberValidate;

public class Is2Power {

    public static void main(String[] args){
        int value = new Double(Math.pow(2,5)).intValue()+1;

        System.out.println(value+":");

        System.out.println(is2Power_1(value));
        System.out.println(is2Power_2(value));
        System.out.println(is2Power_3(value));


        System.out.println("********");
    }

    /**
     * 最佳算法-位运算
     * @param value
     * @return
     */
    public static boolean is2Power_2(int value){
        return (value & (value-1))==0;
    }

    /**
     * 暴力算法
     * @param value
     * @return
     */
    public static boolean is2Power_1(int value){
        if(value <=1){
            return false;
        }

        int tmp = value;
        while(tmp!=1){
            if( tmp%2==0){
                tmp = tmp/2;
            }else{
                return false;
            }
        }
        return true;
    }


    /**
     * 字符串比较法
     */
    public static boolean is2Power_3(int value){
        String str  = Integer.toBinaryString(value);
        boolean result = true;

        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);

            if(i==0){
                if('1'!=c){
                    result = false;
                    break;
                }
            }else{
                if('0'!=c){
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
