package com.qqy.tree;

/**
 * 镜像对称
 * Author:qqy
 */
public class IsMirror {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 判断两颗树是否是镜像对称的
     * 思路：
     *      左子树与右子树镜面对称
     * @param p
     * @param q
     * @return
     */
    private boolean isMirror(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&isMirror(p.left,q.right)&&isMirror(p.right,q.left);
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 思路：
     *      左子树与右子树是镜像对称的
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isMirror(root.left, root.right);
    }
}
