package com.qqy.list;

/**
 * 删除链表中等于给定值 val 的所有节点
 *
 * 方法一：
 *      新开辟一个空间，存放结果的链表。若比较厚不为指定值，尾插至result
 * 方法二：
 *      若当前对象等于给定值，直接跳过；若不等于，则继续比较
 * Author:qqy
 */
public class Remove {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //方法一
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = null; // 结果链表，没有节点
        ListNode last = null;   // 记录结果链表的最后一个节点

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val != val) {
                // 把 cur 节点尾插到 result 链表上

                // 尾插
                cur.next = null;   //???  因为要将cur赋给结果链表，因此要将其的next置为null
                if (result == null) {
                    result = cur;
                } else {
                    last.next = cur;
                }
                // 尾插结束
                // 更新结果链表的最后一个节点
                last = cur;
            }
            cur = next;
        }

        return result;
    }

    //方法二
    public ListNode removeElements2(ListNode head, int val) {
        //头节点为空，返回空
        if (head == null) {
            return null;
        }

        //设当前节点为头节点
        ListNode cur = head;
        //头节点的下一个节点不为空
        //若是最后一个节点不比较->
        //    因为比较的都是当前节点的next，因此虽然最后一个节点没有进入循环，但是上一个节点已经将最后一个节点比较过了
        while (cur.next != null) {
            //且下一个节点的值不是指定值
            if (cur.next.val != val) {
                cur = cur.next;  //下一个不等于给定值，则向后移动，指向下一个
            } else {
                //若等于给定值，则省略给定值(直接删除)
                //因为比较的都是cur的next，因此该步骤把去掉指定值的下一个赋给cur.next
                //不需要后移，在下一次循环中直接比较新的cur.next
                cur.next = cur.next.next;
            }
        }

        //将除头节点以外的都比较完成，比较且更改完成的链表再取头节点比较
        //若头节点为指定值，则返回下一个节点
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
