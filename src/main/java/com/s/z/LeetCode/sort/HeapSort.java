package com.s.z.LeetCode.sort;

/**
 * 建立最大(顶)堆，利用最大堆进行堆排序。
 */

public class HeapSort {

    private int[] array = null;
    private int maxIndex = 0;

    public int[] getBigHeap(int[] input) {
        array = input;
        maxIndex = input.length - 1;
        initBig();
        return array;
    }

    public int[] getSmallHeap(int[] input) {
        array = input;
        maxIndex = input.length - 1;
        initSmall();
        return array;
    }

    public int[] sortAsc(int[] input) {
        getBigHeap(input);
        while(maxIndex > 0) {
            swap(0,maxIndex);
            maxIndex--;
            bigDown(0);
        }
        return array;
    }
    public int[] sortDesc(int[] input) {
        getSmallHeap(input);
        while(maxIndex > 0) {
            swap(0,maxIndex);
            maxIndex--;
            smallDown(0);
        }
        return array;
    }
    //从第一个非叶子结点从下至上，从右至左调整结构
    private void initBig() {
        for (int i = maxIndex; i > 0; i--) {

            int targetIndex = (i + 1) / 2 - 1;
            bigDown(targetIndex);
            if ((i + 1) / 2 == i / 2) {
                i--;
            }
        }
    }

    /**
     * 节点下行
     *
     * @param index
     */
    private void bigDown(int index) {
        int leftIndex = (index + 1) * 2 - 1;
        int rigthIndex = (index + 1) * 2;
        if (leftIndex <= maxIndex) {
            int nextIndex = leftIndex;
            if (rigthIndex <= maxIndex && array[rigthIndex] > array[leftIndex]) {
                nextIndex = rigthIndex;
            }
            if (array[nextIndex] > array[index]) {
                swap(index, nextIndex);
                bigDown(nextIndex);
            }
        }
    }

    //从第一个非叶子结点从下至上，从右至左调整结构
    private void initSmall() {
        for (int i = maxIndex; i > 0; i--) {
            if ((i + 1) / 2 == i / 2) {
                i--;
            }
            int targetIndex = (i + 1) / 2 - 1;
            smallDown(targetIndex);
        }
    }

    /**
     * 节点下行
     *
     * @param index
     */
    private void smallDown(int index) {
        int leftIndex = (index + 1) * 2 - 1;
        int rigthIndex = (index + 1) * 2;
        if (leftIndex <= maxIndex) {
            int nextIndex = leftIndex;
            if (rigthIndex <= maxIndex && array[rigthIndex] < array[leftIndex]) {
                nextIndex = rigthIndex;
            }
            if (array[nextIndex] < array[index]) {
                swap(index, nextIndex);
                smallDown(nextIndex);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //插入新节点后需要上行
    private void up(int index) {

    }
}