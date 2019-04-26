package com.qqy.stackandqueue;

import java.util.Stack;

/**
 * Josephus问题
 * 思路：
 *      1.创建2个栈:stack1,stack2
 *        stack1用于进行游戏操作
 *        stack2主要用于存储幸免于难的人
 *      2.将数据先反向存储在stack1中
 *      3.只剩下一人时，才不进行游戏操作；
 *        否则：
 *          1)每次循环，从stack1出栈至stack2 M 次，stack1 pop 1 次
 *          2)若M次还没进行完或还未pop，stack1就空了
 *              a.记住M的值
 *              b.将stack2中的数出栈至stack1，继续1)
 *      4.最后存活的人(仅剩的一个数据)就是需要的结果
 * Author:qqy
 */
public class Josephus {
    public static int josephus(int M,int N){
        Stack stack1=new Stack();
        Stack stack2=new Stack();
        int count=M;
        if(M==0){
            return N;
        }
        if(N==0){
            return 0;
        }
        //入栈
        for(int i=N;i>0;i--){
            stack1.push(i);
        }
        //循环至只剩1个元素
        while(stack1.size()+stack2.size()!=1){
            //出M次，删1次
            while(count!=0){
                isEmpty1(stack1, stack2);
                stack2.push(stack1.pop());
                count--;
            }
            isEmpty1(stack1, stack2);
            stack1.pop();
            count=M;
        }
        int result= (int) (stack1.isEmpty()?stack2.peek():stack1.peek());
        return result;
    }

    private static void isEmpty1(Stack stack1, Stack stack2) {
        if(stack1.isEmpty()){
            //把stack2中的数全部放入stack1
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(josephus(2, 41));
    }
}
