package com.qqy.tree;

import java.util.LinkedList;

/**
 * 判断是否为完全二叉树
 * 思路：
 *     利用带有空节点的层序遍历
 *         遇到#后剩下的都是#，是完全二叉树
 *         遇到#后，仍有非#，不是完全二叉树
 * Author:qqy
 */
public class IsCompleteBinary {
    public class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
        }
    }

    public boolean isCompleteBinary(Node root){
        if(root==null){
            return true;
        }

        LinkedList<Node> queue=new LinkedList<>();
        queue.addLast(root);
        while(true){
            Node out=queue.pollFirst();
            //一旦遇到空的，则不再向队列中添加，直接判断剩余的是否还有空
            if(out==null){
                break;
            }
            queue.addLast(root.left);
            queue.addLast(root.right);
        }

        while (!queue.isEmpty()){
            Node out=queue.pollFirst();
            if(out!=null){
                return false;
            }
        }
        return true;
    }
}
