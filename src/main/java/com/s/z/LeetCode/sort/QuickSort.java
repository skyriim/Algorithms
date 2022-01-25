package com.s.z.LeetCode.sort;

public class QuickSort {

    public static int[] quickSort(int[] nums) {
        if(nums!=null && nums.length>1){
            quickSort(nums,0,nums.length-1);
        }
        return nums;
    }

    private static void quickSort(int[] nums,int lo,int hi){
        if(hi<=lo)
            return;
        int median = partition(nums,lo,hi);
        quickSort(nums,lo,median-1);
        quickSort(nums,median+1,hi);
    }

    private static int partition(int[] nums, int start, int end){
        int i=start+1,j=end;
        mvMedianToStart(nums,start,end);
        while(i<=j){ //while true
            while(nums[i]<=nums[start]){
                if(i==end)
                    break;
                i++;
            }
            while(nums[j]>=nums[start]){
                if(j==start)
                    break;
                j--;
            }
            //如果使用while true 代替这步，会导致长度为2的排序不进入循环直接swap产生错误
            if(i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,start,j);
        //return 后动的那个
        return j;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //将中位数换到首位
    //先找最小
    private static void mvMedianToStart(int[] nums,int start,int end){
        if(end-start<3){
            return;
        }
        int l = start+1;
        int h = end;
        int m = (l +h)/2;
        if(nums[l]>nums[m]){
            swap(nums,l,m);
        }
        if(nums[l]>nums[h]){
            swap(nums,l,h);
        }
        if(nums[m]>nums[h]){
            swap(nums,m,h);
        }
        swap(nums,start,m);
    }
}
