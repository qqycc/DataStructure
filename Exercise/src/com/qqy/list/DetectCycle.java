package com.qqy.list;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 思路:
 *      若有环定会相遇，一个引用从相遇点出发，一个引用从起点出发
 *      同时开始走，再次相遇一定是入口点
 * Author:qqy
 */
public class DetectCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        do{
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }while(fast!=null&&fast!=slow);
        //如果快的为空了，或快的没有遇上慢的，则无环
        //快的为空，无环
        if(fast==null){
            return null;
        }
        //相遇的情况
        //一个设为起点，一个设为相遇点
        //若再次相遇，则为交点
        ListNode p1=head;
        ListNode p2=slow;
        //一定存在再次相遇的情况
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
