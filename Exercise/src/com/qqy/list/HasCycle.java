package com.qqy.list;

/**
 * 判断链表中是否有环
 * 思路：
 *      设置两个引用，一个快一个慢
 *      -> 若有环，两者终会相遇
 * Author:qqy
 */
public class HasCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        do{
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }while(fast!=slow&&fast!=null);//快的为null或者相遇则跳出循环
        if(fast==null){
            return false;
        }
        return true;
    }
}
