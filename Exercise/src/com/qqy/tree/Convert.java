package com.qqy.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 思路：
 *      1.先将二叉树通过中序遍历变为有序的队列
 *      2.每次从队列中弹出一个节点，将该节点与之前的串成一个双向链表
 *          left相当于prev
 *          right相当于next
 * Author:qqy
 */
public class Convert {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
        }
    }

    /**
     * 初级版
     * 通过list存储后，再进行转换
     */
    private static LinkedList<Node> list=new LinkedList<>();

    public Node Convert(Node pRootOfTree) {
        list.clear();
        List<Node> list=inOrder(pRootOfTree);
        return transform(list);
    }

    public static List<Node> inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            list.addLast(root);
            inOrder(root.right);
        }
        return list;
    }

    public Node transform(List<Node> list){
        Node prev=null;
        Node head=null;
        for(Node node:list){
            node.left=prev;
            if(prev!=null){
                prev.right=node;
            }else{
                head=node;
            }
            prev=node;
        }
        return head;
    }


    /**
     * 优化版
     *      不使用list存储，直接转换为链表
     */
    private static Node prev = null;
    private static Node head = null;
    //链接
    private static void buildDList(Node node) {
        node.left = prev;   // node.prev = prev
        if (prev != null) {
            prev.right = node;  // prev.next = node;
        } else {
            head = node;
        }
        prev = node;
    }

    //中序遍历
    private static void inOrderTraversalSearchTree(Node root) {
        if (root != null) {
            inOrderTraversalSearchTree(root.left);
            buildDList(root);
            inOrderTraversalSearchTree(root.right);
        }
    }

    private static Node searchTreeToSortedList(Node root) {
        prev = null;
        head = null;
        inOrderTraversalSearchTree(root);
        return head;
    }
}
