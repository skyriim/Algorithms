package com.s.z.LeetCode.TwoSum;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class TwoSumSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode resultHeadNode = null;
        Integer v1= -1;
        Integer v2 = -1;
        ListNode point1 = l1;
        ListNode point2 = l2;
        int carry = 0;
        while(point1!=null||point2!=null||carry!=0){
            if(point1!=null){
                v1 = point1.val;
                point1 = point1.next;
            }else{
                v1=null;
            }
            if(point2!=null){
                v2 = point2.val;
                point2 = point2.next;
            }else{
                v2=null;
            }
            int result = carry;
            if(v1!=null){
                result = result + v1;
            }
            if(v2!=null){
                result = result + v2;
            }
            carry = result/10;
            result = result%10;
            if(resultNode ==null){
                resultNode = new ListNode(result);
                resultHeadNode = resultNode;
            }else{
                resultNode.next = new ListNode(result);
                resultNode = resultNode.next;
            }
        }

        return resultHeadNode;
    }

/*    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = new LengthOfLongestSubstringSolution().addTwoNumbers(l1,l2);
    }*/
}
