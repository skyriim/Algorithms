package com.s.z.LeetCode.Integer2Chinese;

public class Integer2Chinese {
    static final String[] chineseValueName = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    static final String[] levelName = {"", "十", "百", "千", "万", "亿"};

    public static String integer2Chinese(int k) {
        int value = k;
        StringBuilder result = new StringBuilder();

        if (k < 0) {
            result.append("负");
            value = -k;
        }
        /* if (value < 10) {
            result.append(chineseValueName[value]);
        }*/
        //规律1：需要分段处理 ①大于亿 ②千万~万 ③千及以下。 规律二：整数最大21亿。规律三：每段的百位、十位出现0则发出零的读音，连续出现并作1个零的读音。

        if (value >= Math.pow(10, 8)) {
            int  part1 = k / (int) Math.pow(10, 8);
            result.append(getNumberStr(part1,levelName[5]));
        }
        if (value >= Math.pow(10, 4)) {
            int  part2 = k%(int)Math.pow(10, 8) / (int) Math.pow(10, 4);
            result.append(getNumberStr(part2,levelName[4]));
        }
        int  part3 = k%(int)Math.pow(10, 4);
        result.append(getNumberStr(part3,null));
        return result.toString();
    }

    private static String getNumberStr(int k, String unit) {
        Integer[] resultData = new Integer[4];
        String[] levels = new String[4];

        int maxAvaliableIndex = 0;
        for (int i = 4; i > 0; i--) {
            int p = (int) Math.pow(10, i-1);
            int q = (int) Math.pow(10, i);
            if (p <= k) {
                resultData[maxAvaliableIndex] = k%q  / p;
                levels[maxAvaliableIndex] = levelName[i-1];
                maxAvaliableIndex++;
            }
        }
        maxAvaliableIndex--;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= maxAvaliableIndex; i++) {
            if (resultData[i] != 0) {
                //补零
                if("".equals(levels[i])){
                    if(i!=0 && resultData[i-1]==0){
                        result.append(chineseValueName[0]);
                    }
                }
                result.append(chineseValueName[resultData[i]]);
                result.append(levels[i]);
            }

        }
        if (unit != null) {
            result.append(unit);
        }
        return result.toString();
    }
}
