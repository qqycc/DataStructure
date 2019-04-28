package com.qqy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的前序、中序、后序遍历
 * Author:qqy
 */
public class PreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //创建一个线性表接收遍历结果
    private ArrayList<Integer> list=new ArrayList<>();
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }
}
