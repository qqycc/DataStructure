package com.qqy.stackandqueue;

/**
 * 栈
 * Author:qqy
 */
public class MyStack {
    //数组
    private int[] array;
    //栈顶
    int top;

    MyStack() {
        this.array = new int[100];
        this.top = 0;
    }

    /**
     * 压栈
     * @param v
     */
    public void push(int v) {
        this.array[this.top++]=v;
    }

    /**
     * 出栈
     * @return 出栈前的栈顶元素
     */
    public int pop() {
        return this.array[--this.top];
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    public int peek() {
        return this.array[this.top-1];
    }

    /**
     * 查看栈中元素个数
     * @return
     */
    public int size() {
        return this.top;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.top == 0;
    }

    public static void print(MyStack stack){
        for(int i=0;i<stack.size();i++){
            System.out.print(stack.array[i]+" ");
        }
    }
}
