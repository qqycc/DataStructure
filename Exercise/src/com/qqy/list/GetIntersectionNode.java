package com.qqy.list;

/**
 * 找到两个单链表相交的起始节点
 *
 * 要求：
 *  如果两个链表没有交点，返回 null.
 *  在返回结果后，两个链表仍须保持原有的结构。
 *  可假定整个链表结构中没有循环。
 *  程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 *  思路：因为节点有val和next -> 不可能出现相交线的情况。
 *       若两个链表有交点，则之后的节点的内容与长度一定相同（Y字型交叉）
 *       -> 若两者的长度不同，则一定是交点之前的长度不同
 *
 *       1.求出两者的长度，让较长的先走完多出来的长度
 *       2.长的短的一起走，并比较
 *       3.比较到结束为止，若有相同的节点则为交点
 * Author:qqy
 */
public class GetIntersectionNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        int lengthA=getLength(headA);
        int lengthB=getLength(headB);

        int num=0;
        if(lengthA>lengthB){
            num=lengthA-lengthB;
            while(num!=0){
                curA=curA.next;
                num--;
            }
        }else{
            num=lengthB-lengthA;
            while(num!=0){
                curB=curB.next;
                num--;
            }
        }
        while(curA!=curB){
            curA=curA.next;
            curB=curB.next;
        }
        return curA;
    }

    public int getLength(ListNode list){
        int length=0;
        for(ListNode i=list;i!=null;i=i.next) {
            length++;
        }
        return length;
    }
}
