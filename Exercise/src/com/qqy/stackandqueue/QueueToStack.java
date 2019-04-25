package com.qqy.stackandqueue;

import java.util.LinkedList;

/**
 * 使用队列实现栈的下列操作：
 *  push(x) -- 元素 x 入栈
 *  pop() -- 移除栈顶元素
 *  top() -- 获取栈顶元素
 *  empty() -- 返回栈是否为空
 *  只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 *
 * 思路：
 *      使用LinkedList当做队列
 *        把入队列当做入栈
 *        出栈：
 *           出队size-1个数据，再次入队。
 *           第size个数据出队即为出栈。
 * Author:qqy
 */
public class QueueToStack {
    private LinkedList<Integer> queue;
    public QueueToStack(){
        this.queue=new LinkedList<>();
    }

    public void push(int x) {
        this.queue.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size=this.queue.size();
        for(int i=0;i<size-1;i++) {
            int temp = this.queue.poll();
           this.queue.addLast(temp);
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int size=this.queue.size();
        for(int i=0;i<size-1;i++) {
            int temp = this.queue.poll();
            this.queue.addLast(temp);
        }
        //查看栈顶元素
        int result=queue.peek();
        //将该元素继续挪向队尾
        int temp=this.queue.poll();
        this.queue.addLast(temp);
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.size()==0;
    }
}
