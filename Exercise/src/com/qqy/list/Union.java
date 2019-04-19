package com.qqy.list;

/**
 * 求两个有序链表的并
 * 思路：
 *      两个链表依次比较
 *          相等 -> L1放入result
 *          不相等 -> 较小的放入result,较小的后移，继续比较
 *      当任一个链表为空，停止比较，将剩下的全部放入result
 * Author:qqy
 */
public class Union {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode union(ListNode L1, ListNode L2){
        ListNode result=null;
        ListNode last=null;
        if(L1==null){
            return L2;
        }
        if(L2==null){
            return L1;
        }
        while(L1!=null&&L2!=null){
            ListNode next1=L1.next;
            L1.next=null;
            if(L1.val==L2.val){
                if(result==null){
                    result=L1;
                }else{
                    last.next=L1;
                }
                last=L1;
                L1=next1;
                L2=L2.next;
            }else{
                if(L1.val<L2.val){
                    if(result==null){
                        result=L1;
                    }else{
                        last.next=L1;
                    }
                    last=L1;
                    L1=next1;
                }else {
                    ListNode next2=L2.next;
                    L2.next=null;
                    if(result==null){
                        result=L2;
                    }else{
                        last.next=L2;
                    }
                    last=L2;
                    L2=next2;
                }
            }
        }
        if(L1==null){
            last.next=L2;
        }
        if(L2==null){
            last.next=L1;
        }
        return result;
    }
    public static void main(String[] args) {
        ListNode node= new ListNode(1);
        ListNode node1= new ListNode(2);
        ListNode node2= new ListNode(3);
        ListNode node3= new ListNode(4);
        ListNode node4= new ListNode(5);
        ListNode node5= new ListNode(6);
        ListNode node6= new ListNode(7);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=null;

        ListNode node10= new ListNode(1);
        ListNode node11= new ListNode(3);
        ListNode node12= new ListNode(5);
        ListNode node13= new ListNode(7);
        ListNode node14= new ListNode(9);
        ListNode node15= new ListNode(10);
        node10.next=node11;
        node11.next=node12;
        node12.next=node13;
        node13.next=node14;
        node14.next=node15;
        node15.next=null;

        ListNode result=union(node,node10);

        for(ListNode i=result;i!=null;i=i.next){
            System.out.print(i.val+" ");
        }


    }
}
