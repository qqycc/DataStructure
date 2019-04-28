package com.qqy.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归的前序、中序、后序遍历
 * Author:qqy
 */
public class Order {
    private static class Node {
        int value;
        //左子树
        Node left;
        //右子树
        Node right;

        Node(int v) {
            this.value = v;
        }
    }

    //前序遍历
    public static void preOrder(Node root) {
        //先准备栈
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.value);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    //中序遍历
    public static void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.value);
            cur = top.right;
        }
    }

    //后序遍历
    public static void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;//上一次被完整后序遍历过的树的根结点

        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 向左走到头了，需要回溯
            // 从栈里取出结点进行回溯
            // 目前栈里的所有结点的右子树都没有进行遍历
            //top的右子树分为
            //  1.没有右子树 -> 直接取得top，last=top
            //  2.有右子树 -> 遍历过    直接取得top，last=top
            //               没有遍历，继续遍历右子树  cur=top.right
            Node top = stack.peek();
            //top没有右孩子
            if (top.right == null) {
                stack.pop();
                System.out.println(top.value);
                last = top;
            } else if (top.right == last) {  //有右孩子且已遍历
                stack.pop();
                System.out.println(top.value);
                last = top;
            } else {  //有右孩子，还未遍历
                //遍历右子树
                cur = top.right;
            }
        }
    }
}
