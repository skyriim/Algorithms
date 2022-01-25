package com.s.z.Math;

import static java.lang.Math.abs;

public class Sqrt {
    public static float sqrt(float value, float diff) {
        if (value == 0f || value == 1f) {
            return value;
        }
        float left = 0, right = value;
        float mid = (left + value) / 2;
        while (abs(value / mid - mid) > diff) {
            if (value / mid > mid) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }

    public static float sqrt_copy(float value, float diff) {
        if (value == 0f || value == 1f) {
            return value;
        }
        float left=0,right=value,mid;
        do{
            mid = (left+right)/2;
            if(mid>value/mid){
                right = mid;
            }else if(mid<value/mid){
                left = mid;
            }else{
                break;
            }
        }while(Math.abs(value/mid - mid)>diff);

        return mid;
    }

    /**
     * 计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 或者换一种解法，使用上面的函数，取整数部分
     * @param value
     * @return
     */
    public static float sqrtInt(int value) {
        if (value == 0 || value == 1) {
            return value;
        }
        int left = 1, right = value, mid = -1,result=-1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (value / mid == mid) {
                return mid;
            } else if (value / mid < mid) {
                right = mid - 1;
            } else if (value / mid > mid) {
                left = mid + 1;
                // 因为可能最后一次是无效比较 所以保留上一次满足条件的结果
                result = mid;
            }
        }
        return result;
    }
}
