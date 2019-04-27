package com.qqy.stackandqueue;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。（时间复杂度为O(1)）
 *  push(x) -- 将元素 x 推入栈中。
 *  pop() -- 删除栈顶的元素。
 *  top() -- 获取栈顶元素。
 *  getMin() -- 检索栈中的最小元素。
 * 思路：
 *      需要两个栈来实现，一个栈提供正常使用，另一个栈(最小值栈)存放每次入栈之后的最小值
 *      每次出栈时，最小值栈也出栈，所出栈的元素就是最小元素
 *
 * Author:qqy
 */
public class MinStack {
    Stack<Integer> min;
    Stack<Integer> normal;

    public MinStack() {
        this.min=new Stack<>();
        this.normal=new Stack<>();
    }

    public void push(int x) {
        //入正常栈
        this.normal.push(x);
        //入最小值栈
        if(this.min.isEmpty()){
            this.min.push(x);
        }else{
            int temp=this.min.peek();
            if(temp<x){
                this.min.push(temp);
            }else{
                this.min.push(x);
            }
        }
    }

    public void pop() {
        //出正常栈
        this.normal.pop();
        //出最小值栈
        this.min.pop();
    }

    public int top() {
        //正常查看栈顶元素
       return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
