package com.qqy.list;

/**
 * 链表的增删
 * Author:qqy
 */
public class MyLinkedList {
    /**
     * 定义一个内部类，表示结点
     */
    public class Node {
        //保存有效数据
        private int value;
        //下一个结点的线索（引用）
        private Node next;

        public Node(int v) {
            this.value = v;
            this.next = null;
        }
    }

    //保存链表中第一个结点的引用，若无结点 -> head=null
    private Node head;

    MyLinkedList(){
        this.head=null;
    }

    public void pushFront(int item){
        Node node=new Node(item);
        node.next=this.head;
        this.head=node;
    }

    public void pushBack(int item){
        Node node=new Node(item);
        //链表没有结点
        if(this.head==null){
            this.head=node;
        }else {
            Node cur = this.head;
            //得到最后一个结点
            while (cur.next != null) {
                cur = cur.next;
            }
            //将node赋给最后一个结点的next
            cur.next = node;
        }
    }

    public void popFront(){
        if(this.head==null){
            throw new Error();
        }
        this.head=this.head.next;
    }

    public void popBack(){
        if(this.head==null){
            throw new Error();
        }
        //只有一个结点
        if(this.head.next==null){
            this.head=null;
        }else {
            Node cur = this.head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
        }
    }

    //通过循环遍历链表的每一个结点
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.value);
            if(cur.next!=null){
                System.out.print("-->");
            }
            cur=cur.next;
        }
    }
}
