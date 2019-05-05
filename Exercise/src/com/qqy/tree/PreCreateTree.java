package com.qqy.tree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 带有空节点的前序创建二叉树
 * 再使用中序遍历
 * Author:qqy
 */
public class PreCreateTree {
    private static class Node {
        char value;
        //左子树
        Node left;
        //右子树
        Node right;

        Node(char v) {
            this.value = v;
        }
    }

    public static RV createTree(char[] Order) {
        //终止条件
        //若所给遍历的个数为0，则认为创建空树
        if (Order == null) {
            return new RV(null, 0);
        }
        //如果根结点为"#"，返回null，1
        if (Order[0] == '#') {
            return new RV(null, 1);
        }
        //1.创建根节点
        Node root = new Node(Order[0]);

        //递归
        //左前序遍历
        char[] leftOrder = new char[Order.length - 1];
        leftOrder = Arrays.copyOfRange(Order, 1, Order.length);
        //创建左子树
        RV returnLeft = createTree(leftOrder);

        //右前序遍历
        char[] rightOrder = new char[Order.length - 1 - returnLeft.used];
        rightOrder = Arrays.copyOfRange(Order, 1 + returnLeft.used, Order.length);
        //创建右子树
        RV returnRight = createTree(rightOrder);

        //左右子树与根结点绑定
        root.left = returnLeft.r;
        root.right = returnRight.r;

        return new RV(root, returnLeft.used + returnRight.used + 1);
    }


    static class RV {
        Node r;
        int used;

        RV(Node r, int used) {
            this.r = r;
            this.used = used;
        }
    }
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value+" ");
            inOrder(root.right);
        }
    }
    //
//    public static void main(String[] args) {
//        String str="abc##de#g##f###";
//        char[] ch=new char[str.length()];
//        str.getChars(0,str.length(),ch,0);
////        char[] ch=new char[]{'a','b','c','#','#','d','e','#','g','#','#','f','#','#','#'};
//        RV root=buildTree(ch);
//        inOrder(root.r);
//    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()) {
            String str=sc.nextLine();
            char[] ch=new char[str.length()];
            str.getChars(0,str.length(),ch,0);
            RV root=createTree(ch);
            inOrder(root.r);
        }
    }
}
