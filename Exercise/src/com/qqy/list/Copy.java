package com.qqy.list;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 *
 * 思路：
 *      不可以复制一个节点，再复制其指向 -> 会使得复制生成的节点指向的是旧链表中的节点
 *   分为两步走：
 *       1.遍历原链表的所有节点，并复制新节点，各新结点插到原链表节点的后面（只保留节点结构）
 *           -> 旧1.next=新1; 新1.next=旧2; 旧2.next=新2; ... ...
 *       2.遍历原链表的所有节点，进行新节点random的设置
 *           -> cur.next.random=cur.random.next
 *       3.将链表拆分为新链表和旧链表
 *
 * Author:qqy
 */
public class Copy {
    public static class Node {
        public int val;
        public Node next;
        public Node random; //链表中任一节点的引用或者为空

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //复制节点
        Node cur = head;
        while (cur != null) {
            Node copy = new Node();
            copy.val = cur.val;
            //插入各旧节点之后
            copy.next = cur.next;
            cur.next = copy;
            // 让 cur 走向下一个原链表的节点
            cur = cur.next.next;
        }

        //设置新节点的random关系
        cur = head;
        while (cur != null) {
            Node newNode = cur.next;
            if (cur.random == null) {
                newNode.random = null;
            } else {
                newNode.random = cur.random.next;
            }
            // cur 走到下一个老节点
            cur = cur.next.next;
        }

        //拆
        cur = head;
        Node result = head.next;
        while (cur != null) {
            Node newNode = cur.next;
            //旧
            cur.next = newNode.next;
            //新
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
            cur = cur.next;
        }
        return result;
    }
}

