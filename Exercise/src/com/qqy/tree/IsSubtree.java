package com.qqy.tree;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * 思路：
 *      将该树中的子树与另一个树比较是否相同
 *      用s树的根结点跟t树比较，若不同，用s树的左子树判断，还不是，用右子树判断。
 * Author:qqy
 */
public class IsSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(isSame(s,t)){
            return true;
        }
        if(isSubtree(s.left,t)){
            return true;
        }
        return isSubtree(s.right,t);
    }
    public boolean isSame(TreeNode s, TreeNode t){
        if(s==null&&t==null){
            return true;
        }
        if(s==null||t==null){
            return false;
        }
        return s.val==t.val&&isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
}
