package com.qqy.tree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先：
 *    对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *    满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
 * 思路：
 *      1.p、q其中一个为root,结果为root
 *      2.p、q不在同一棵子树上，结果为root。
 *      3.p、q在同一棵左子树上
 *          递归lowestCommonAncestor(root.left,p,q)
 *           在同一颗右子树上
 *          递归lowestCommonAncestor(root.right,p,q)
 * Author:qqy
 */
public class LowestCommonAncestor {
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
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(p==root||q==root){
            return root;
        }
        if(contains(root.left,p.value)&&contains(root.left,q.value)){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(contains(root.right,p.value)&&contains(root.right,q.value)){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    public boolean contains(Node root,int v){
        if(root==null){
            return false;
        }
        if(root.value==v){
            return true;
        }
        if(contains(root.left,v)){
            return true;
        }
        return contains(root.right,v);
    }
}
