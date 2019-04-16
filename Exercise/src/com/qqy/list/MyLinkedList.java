package com.qqy.list;

/**
 * 链表
 * Author:qqy
 */
public class MyLinkedList {
    /**
     * 定义一个内部类，表示节点
     */
    public class Node {
        //保存有效数据
        private int value;
        //下一个节点的线索（引用）
        private Node next;

        public Node(int v) {
            this.value = v;
            this.next = null;
        }
    }

    //保存链表中第一个节点的引用，若无节点 -> head=null
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
        //链表没有节点
        if(this.head==null){
            this.head=node;
        }else {
            Node cur = this.head;
            //得到最后一个节点
            while (cur.next != null) {
                cur = cur.next;
            }
            //将node赋给最后一个节点的next
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

    //中间插入
    public boolean addIndex(int index, int v) {
        Node node=new Node(v);
        if(index==0){
            node.next=this.head.next;
           this.head=node;
        }else {
            Node cur=this.head;
            for (int i = 0; cur.next!=null&& i < index - 1; i++) {
                cur = cur.next;
            }
            if(cur.next==null){
                return false;
            }
            node.next=cur.next;
            cur.next=node;
        }
        return true;
    }

    //是否包含指定元素
    public boolean contains(int v) {
        Node node=new Node(v);
        Node cur=this.head;
        while(cur!=null){
            if(cur==node){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //通过循环遍历链表的每一个节点
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
