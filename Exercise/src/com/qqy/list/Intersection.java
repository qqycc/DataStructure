package com.qqy.list;


/**
 * 求两个有序链表的交
 * 思路：
 *      两个链表依次比较
 *          相等 -> 放入result
 *          不相等 -> 较小的后移，继续比较
 * Author:qqy
 */
public class Intersection {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode intersection(ListNode L1, ListNode L2) {
        ListNode result = null;
        ListNode last=null;
        if (L1 == null || L2 == null) {
            return null;
        }

        while (L1 != null && L2 != null) {
            if (L1.val == L2.val) {
                ListNode next=L1.next;
                L1.next=null;
                if(result==null){
                    result=L1;
                }else{
                    last.next=L1;
                }
                last = L1;
                L1 = next;
                L2 = L2.next;
            } else {
                if (L1.val < L2.val) {
                    L1 = L1.next;
                } else {
                    L2 = L2.next;
                }
            }
        }
        return result;
    }
}
