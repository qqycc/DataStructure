package com.qqy.stackandqueue;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *  push(x) -- 将一个元素放入队列的尾部。
 *  pop() -- 从队列首部移除元素。
 *  peek() -- 返回队列首部的元素。
 *  empty() -- 返回队列是否为空。
 *
 * 思路：
 *      需要使用两个栈来实现（左栈、右栈）
 *      入队：
 *          入右栈
 *      出队：
 *          1.当左栈为空的时，将右栈的数据出栈再入栈至左栈。
 *          2.再从左栈出栈
 *          切记：
 *      查看队首元素：
 *          若左栈不为空，查看左栈的栈顶元素；否则执行出队1，之后查看左栈的栈顶元素
 *      是否为空：
 *          判断两个栈是否都为空，若都为空，则是空队列
 * Author:qqy
 */
public class StackToQueue {
    Stack<Integer> left;
    Stack<Integer> right;
    /** Initialize your data structure here. */
    public StackToQueue() {
        left=new Stack<>();
        right=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //先入右栈
        right.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(left.isEmpty()){
//            if(right.isEmpty()){
//                return left.pop();
//            }
            //for(int i=0;i<right.size();i++){
            while(!right.isEmpty()){
                int temp=right.pop();
                left.push(temp);
            }
        }
        return left.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(left.isEmpty()){
//            if(right.isEmpty()){
//                return left.pop();
//            }
            //for(int i=0;i<right.size();i++){
            while(!right.isEmpty()){
                int temp=right.pop();
                left.push(temp);
            }
        }
        return left.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return left.isEmpty()&&right.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack=new Stack();
        System.out.println(stack.pop());
    }
}
