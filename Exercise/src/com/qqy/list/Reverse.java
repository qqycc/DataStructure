package com.qqy.list;

/**
 * 反转一个单链表
 *
 * 方法一：
 *      将当前链表中的元素从头取出，头插至结果链表
 * 方法二：
 *      依次让当前元素的next指向前一个元素
 * Author:qqy
 */
public class Reverse {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //方法一
    public ListNode reverseList(ListNode head) {
        ListNode result = null; // 结果链表
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = result;
            result = cur;

            cur = next;
        }
        return result;
    }

    //方法二
    public ListNode reverseList1(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=head.next;
        while(cur!=null){
            cur.next=prev;
            prev=cur;
            cur=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }

    //优化的方法二
    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}
