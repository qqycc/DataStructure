package com.qqy.list;

/**
 * 输出该链表中倒数第K个节点
 *
 * 思路：
 *      双引用
 *          慢引用与快引用始终保持k个距离
 *          快引用到达末尾时，则慢引用指向第K个节点
 * Author:qqy
 */
public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode front = head;
        ListNode back = head;

        int i;
        for (i = 0; front != null && i < k; i++) {
            front = front.next;
        }

        if (front == null && i < k) {
            // k 大于 节点个数
            return null;
        } else if (front == null) {
            return head;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        return back;
    }

}
