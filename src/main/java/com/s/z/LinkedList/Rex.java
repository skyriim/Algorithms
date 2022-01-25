package com.s.z.LinkedList;

import java.util.ArrayList;

public class Rex {

    public final static String[] IsNullSign = {
            "null",
            "0"
    };

    public final static String[] ElementNullSign = {
            "[]",
            ":\"0\"",
            ":null",
    };
    public final static String[] ElementZeroSuffix ={
            ":0",
            ":0]",
            ":0}"
    };

    public final static String[] regexs = {
            //字符中包含‘:0’但排除小于1.0的小数的情况
            "(.*\\D:0\\D\\D.*)|(.*\\D:0})"
    };


    public final static int alertMaxLength = 77;


    public static void main(String args[]){
        String json = "{\"の\":0,\"a\":1,\"b\":0,\"c\":[\"j\":0.1,\"h\":0,\"i\":0],\"d\":0.234151,\"e\":0,\"f\":\"fdafaefadsfeafdsfawe\",\"g\":0}";
        String parts = GetJsonAbnormityPart(json);
        System.out.println(parts);


    }
    /*
* 结果字符异常部分提取
* */
    private static String GetJsonAbnormityPart(String json){
        /*if(json.length()<=alertMaxLength){
            return json;
        }*/


        String[] parts = json.trim().split(",");
        ArrayList<Integer> resultIndexs = new ArrayList<Integer>();

        for(int i =0;i<parts.length;i++){
            String item = parts[i];
            if(IsZeroAndNull(item)){
                resultIndexs.add(i);
            }
        }

        StringBuilder resultBuilder = new StringBuilder();

        //报警结果第一个省略号
        if(resultIndexs.get(0)!=0){
            resultBuilder.append("...");
        }
        for(int i =0;i<resultIndexs.size();i++){
            if(i!=0){
                if(resultIndexs.get(i)==(resultIndexs.get(i-1)+1)){
                    resultBuilder.append(",");
                }else{
                    resultBuilder.append("...");
                }
            }
            resultBuilder.append(parts[resultIndexs.get(i)]);
        }
        //报警结果最后一个省略号
        if(resultIndexs.get(resultIndexs.size()-1)!=(parts.length-1)){
            resultBuilder.append("...");
        }

        return resultBuilder.toString();
    }
    /*
    * 判断是否异常
    * */
    private static boolean IsZeroAndNull(String item){

        for(String sign : ElementNullSign){
            if(item.contains(sign)){
                return true;
            }
        }
        for(String suffix : ElementZeroSuffix){
            if(item.endsWith(suffix)){
                return true;
            }
        }

        return false;
    }

}
