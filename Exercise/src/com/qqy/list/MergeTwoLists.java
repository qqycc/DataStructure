package com.qqy.list;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 *
 * 思路：
 *      两个链表从第一个开始比较，小的尾插至结果链表，该链表节点向后移动一个，继续比较
 * Author:qqy
 */
public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = null; // 结果链表的第一个节点
        ListNode last = null;   // 记录结果链表的最后一个节点

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                // 1. 让 cur1 可以在运行后执行 原 cur1 的下一个节点
                // 2. 让 cur1 尾插到 [result, last] 链表上
                // 3. 更新 last
                ListNode next = cur1.next;

                // 把 cur1 尾插到 result 上
                cur1.next = null;
                if (result == null) {
                    // result 链表中没有节点
                    result = cur1;
                } else {
                    // result 链表中有节点
                    last.next = cur1;
                }
                last = cur1;    // 更新最后一个节点记录
                cur1 = next;
            } else {
                ListNode next = cur2.next;

                // 把 cur2 尾插到 result 上
                cur2.next = null;
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }

        if (cur1 != null) {
            last.next = cur1;
        }

        if (cur2 != null) {
            last.next = cur2;
        }
        return result;
    }
}
