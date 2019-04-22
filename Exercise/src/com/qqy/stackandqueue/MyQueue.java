package com.qqy.stackandqueue;

/**
 * 队列
 * Author:qqy
 */
public class MyQueue {
    private class Node {
        int value;
        Node next;
    }

    Node head;
    Node last;

    MyQueue() {
        this.head = this.last = null;
    }

    /**
     * 入队（尾插）
     * @param v
     */
    public void push(int v) {
        Node node=new Node();
        node.value=v;
        node.next=null;
        if(this.head==null){
            this.head=this.last=node;
        }else{
            this.last=this.last.next=node;
        }
    }

    /**
     * 出队（头删）
     * @return
     */
    public int pop() {
        int v=this.head.value;
        this.head=this.head.next;
        if(this.head==null){
            this.last=null;
        }
        return v;
    }

    /**
     * 返回队首元素
     * @return
     */
    public int front() {
        return this.head.value;
    }

    /**
     * 查看队列中元素个数
     * @return
     */
    public int size() {
        int size=0;
        for(Node i=this.head;i!=null;i=i.next){
            size++;
        }
        return size;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.head==null;
    }

    public void print(){
        for(Node i=this.head;i!=null;i=i.next){
            System.out.print(i.value+" ");
        }
    }
}
