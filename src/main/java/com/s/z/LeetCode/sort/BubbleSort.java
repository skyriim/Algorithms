package com.s.z.LeetCode.sort;

public  class BubbleSort {
    public static void sortAsc(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }

    }
    private static void swap(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
