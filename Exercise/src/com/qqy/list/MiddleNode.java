package com.qqy.list;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点
 *
 * 思路：
 *      双引用遍历（快慢引用）-快的走一步，慢的走一步，快的再走一步
 * Author:qqy
 */
public class MiddleNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        //fast不为空，slow一定不为空
        while(fast!=null){
            fast=fast.next;
            if(fast==null){
                break;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
