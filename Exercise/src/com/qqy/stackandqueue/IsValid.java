package com.qqy.stackandqueue;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *  有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *      空字符串可被认为是有效字符串。
 *
 * 思路：
 *      1.遍历每个字符
 *      2.若是左括号，压栈；
 *      3.若是右括号
 *          1)先判断是否为空栈，
 *             a.空栈，返回false(不匹配)
 *             b.非空栈 -> 2)
 *          2)查看栈顶元素；
 *             a.匹配，出栈
 *             b.不匹配，返回false
 *      4.当遍历完后，判断栈是否为空
 *          a.空栈，返回true
 *          b.非空栈，返回false(左括号多余)
 * Author:qqy
 */
public class IsValid {
    public boolean isValid(String s) {
        //创建一个栈
        Stack<Character> stack=new Stack<>();
        //遍历字符串
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='{'||ch=='['||ch=='('){
                //压栈
                stack.push(ch);
            }
            if(ch=='}'||ch==']'||ch==')'){
                if(stack.isEmpty()){
                    return false;
                }
                while(!stack.isEmpty()){
                    char left= stack.pop();
                    if(!((left == '(' && ch == ')')
                            || (left == '[' && ch == ']')
                            || (left == '{' && ch == '}'))){
                        return false;
                    }
                    break;
                }
            }
        }
        //遍历完成，判断是否为空栈
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
