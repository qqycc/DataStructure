package com.qqy.tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 平衡二叉树：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 *
 * Author:qqy
 */
public class IsBalanced {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        //判断左子树的高度和右子树的高度差是否大于1
        //空树是平衡树
        if(root==null){
            return true;
        }
        //如果左子树平衡，整个不一定平衡；但若不平衡，则整个一定不平衡
        if(!isBalanced(root.left)){
            return false;
        }
        if(!isBalanced(root.right)){
            return false;
        }
        return height(root.left) - height(root.right) <= 1 && height(root.left) - height(root.right) >= -1;
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return java.lang.Math.max(height(root.left),height(root.right))+1;
    }
}
