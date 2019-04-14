package com.qqy.list;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
 *
 * 思路：
 *      因为是有序链表，重复的值一定是挨着的
 *      1.设置两个标记P1、P2，比较两者
 *          a. p1！=p2后移
 *          b. p1==p2移动至null或者不等于p1的下一个位置
 * Author:qqy
 */
public class DeleteDuplication {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return head;
        }

        // 设置一个假结点，消除第一个结点没有前驱的特殊性
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;  // prev 永远是 p1 的前驱结点，用来删除结点
        // p1 和 p2 是进行比较的两个结点
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            if (p1.val != p2.val) {
                // 因为有序，p1 和 p2 不等，和 p2 的 next 更不会相等
                prev = prev.next;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                while (p2 != null && p2.val == p1.val) {
                    p2 = p2.next;
                }

                prev.next = p2;
                p1 = p2;

                if (p2 != null) {
                    p2 = p2.next;
                }
            }
        }

        return dummy.next;
    }
}

