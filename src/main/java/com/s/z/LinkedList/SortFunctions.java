package com.s.z.LinkedList;

/**
 * Created by ZhangShuo on 2017/12/21.
 */
public class SortFunctions {

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};
        A = new int[]{3, 6, 2, 4, 5, 1};
        A = new int[]{1, 8, 8, 0, 1, 4, 1, 8, 8, 4, 7};
        //straightInsertionSort(A);
        //shellSort(A);
        simpleSelectionSort(A);
    }

    /*
     * Straight Insertion Sort
     * */
    public static void straightInsertionSort(int[] A) {
        int len = A.length;
        for (int i = 1; i < len; i++) {
            int cur = A[i];
            int j = i - 1;
            for (; j >= 0 && A[j] > cur; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = cur;
        }
    }

    /*
     * a (better) kind of insertion sort
     * */
    public static void shellSort(int[] A) {
        if (A == null && A.length < 2) {
            return;
        }
        int gap = A.length;
        gap = gap == 2 ? 1 : (int) (gap / 2.2);
        //比较优秀的取跨度公式
        for (; gap >= 1; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {

            //分组，gap为1时只有一个组
            for (int i = 0; i < gap; i++) {
                // insert sort
                for (int j = i + gap; j < A.length; j += gap) {
                    for (int k = j; k - gap >= 0; k -= gap) {
                        if (A[k] < A[k - gap]) {
                            int temp = A[k - gap];
                            A[k - gap] = A[k];
                            A[k] = temp;
                        }
                    }
                }
            }
        }
        //排序完成
    }

    /*
     * simple selection sort
     * */
    public static void simpleSelectionSort(int[] A) {
        int length = A.length;
        for (int i = 0; i < length-1; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
    }

    /*
    * heap sort
    * */
    public static void heapSort(int[] A){

    }

}