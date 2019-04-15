package com.qqy.list;

/**
 * 判断是否为回文结构
 *
 * 思路：
 *      找到中间结点，中间后的（包括中间）头插至新的链表，与原链表比较，相等返回true
 * Author:qqy
 */
public class PalindromeList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        return len;
    }

    public ListNode reverse(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = result;
            result = cur;

            cur = next;
        }

        return result;
    }

    //方法一：根据链表长度查找中间元素
    public boolean chkPalindrome(ListNode A) {
        // write code here
        int len = length(A);
        int halfLen = len / 2;

        ListNode middle = A;
        for (int i = 0; i < halfLen; i++) {
            middle = middle.next;
        }

        ListNode r = reverse(middle);
        ListNode c1 = A;
        ListNode c2 = r;


        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) {
                return false;
            }

            c1 = c1.next;
            c2 = c2.next;
        }

        return true;
    }

    //方法二：双引用查找中间元素
    public boolean chkPalindrome1(ListNode A) {
        ListNode fast=A;
        ListNode slow=A;
        ListNode result=null;

        while(fast!=null){
            fast=fast.next;
            if(fast==null){
                break;
            }
            slow=slow.next;
            fast=fast.next;
        }

        //slow为中间结点，将之后的头插入新链表
        while(slow!=null){
            ListNode next=slow.next;
            slow.next=result;
            result=slow;
            slow=next;
        }

        while(result!=null){
            if(A.val==result.val){
                A=A.next;
                result=result.next;
            }else{
                return false;
            }
        }
        return true;

    }
}
