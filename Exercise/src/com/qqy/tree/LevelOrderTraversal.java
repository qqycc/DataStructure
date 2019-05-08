package com.qqy.tree;

import java.util.LinkedList;

/**
 * 层序遍历
 * Author:qqy
 */
public class LevelOrderTraversal {
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
    public static void levelOrderTraversal(Node root) {
        if(root==null){
            return;
        }
        //存放节点
        LinkedList<Node> queue=new LinkedList();
        //根节点放入队列
        queue.addLast(root);
        //若队列不为空，则一直 出一个进*个(左右子树为空则不进入)
        while(!queue.isEmpty()) {
            Node out=queue.pollFirst();
            System.out.println(out.value);
            //找下线
            if(out.left!=null){
                queue.addLast(out.left);
            }
            if(out.right!=null){
                queue.addLast(out.right);
            }
        }
    }
}
