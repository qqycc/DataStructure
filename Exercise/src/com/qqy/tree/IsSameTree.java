package com.qqy.tree;

/**
 *给定两个二叉树，编写一个函数来检验它们是否相同。
 *如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 思路：
 *      1.前序不能够唯一的确定二叉树，但前序+中序可以唯一的确定二叉树
 *      2.树相同，即根相同、左子树相同，右子树相同
 *         递归思想：根相同、左子树相同，右子树相同
 *         终止条件：判断是否为空树，若两个都为空树，相同；
 *                  若一个空树，一个非空树，不同
 * Author:qqy
 */
public class IsSameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
