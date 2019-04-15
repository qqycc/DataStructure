package com.qqy.list;

/**
 * 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 *
 * 思路：
 *      将大于X的放在链表1，小于等于X的放在链表2，再将链表1接在链表2后
 * Author:qqy
 */
public class Partition {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        ListNode small = null;  // 小于 x
        ListNode smallLast = null;  // 小于 x 的最后一个结点
        ListNode big = null;    // 大于等于 x
        ListNode bigLast = null;    // 大于等于 x 的最后一个结点

        ListNode cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            // 小于 x，尾插到 small，大于等于 x，尾插到 big
            if (cur.val < x) {
                // 把 cur 尾插到 small 链表上
                if (small == null) {
                    small = cur;
                } else {
                    smallLast.next = cur;
                }

                // 更新最后一个链表的结点记录
                smallLast = cur;
            } else {
                // 把 cur 尾插到 big 链表上
                if (big == null) {
                    big = cur;
                } else {
                    bigLast.next = cur;
                }

                // 更新最后一个链表的结点记录
                bigLast = cur;
            }

            cur = next;
        }

        // 需要考虑其中有链表为空的情况
        if (small == null) {
            return big;
        } else {
            smallLast.next = big;
            return small;
        }
    }
}
