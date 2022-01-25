package com.s.z.LeetCode.TwoSum;

/**
 * @author ：Zhang Shuo
 * @date ：Created in 2019/7/19 11:48
 * @description：
 * @modified By：
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode p1 =l1,p2 = l2;
        Integer v1 =null,v2=null;
        //int
        for(int i = 0;i>0;i++){
            if(p1!=null){
                v1 = p1.val;
                p1 = p1.next;
            }
            if(p2!=null){
                v2 = p2.val;
                p2 = p2.next;
            }
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nodeJ = l1;
        ListNode nodeK = l2;
        int result = 0;
        Integer j;
        Integer k;
        for(int i =1;i>0;i=i*10){
            if(nodeJ!=null){
                j = nodeJ.val;
                nodeJ = nodeJ.next;
            }else{
                j=null;
            }
            if(nodeK!=null){
                k = nodeK.val;
                nodeK = nodeK.next;
            }else{
                k=null;
            }

            if(j!=null){
                result = result + j*i;
            }
            if(k!=null){
                result = result + k*i;
            }

            if(j==null && k ==null){
                break;
            }
        }
        ListNode resultNode = new ListNode(-1);
        String resultString = result+"";
        ListNode pointNode = resultNode;
        for(int i =resultString.length()-1;i>=0;i--){
            ListNode temp = new ListNode( Integer.parseInt(resultString.charAt(i)+""));
            if(pointNode.val ==-1){
                pointNode.val = temp.val;
            }else{
                pointNode.next = temp;
                pointNode = pointNode.next;
            }
        }
        return resultNode;
    }


}