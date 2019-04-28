package com.qqy.tree;

/**
 * 树
 * Author:qqy
 */
public class Tree {
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
    // 当树是空树，node = null;

    /**
     * 前序遍历
     * 根、左子树、右子树
     *
     * @param root
     */
    private static void preOrderTraversal(Node root) {
        //root==null为出口
        if (root != null) {
            System.out.println(root.value);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * 中序遍历
     * 左子树、根、右子树
     *
     * @param root
     */
    private static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.value);
            inOrderTraversal(root.right);
        }
    }

    /**
     * 后序遍历
     * 左子树、右子树、根
     *
     * @param root
     */
    private static void postOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.println(root);
        }
    }

    /**
     * 求二叉树结点的个数
     *
     * @param root
     */
    private static int count = 0;

    //遍历思想:定义一个变量用于计数，然后后序遍历
    private static void countByTraversal(Node root) {
        if (root != null) {
            countByTraversal(root.left);
            countByTraversal(root.right);
            count++;
        }
    }

    //递归思想：总的结点个数=左子树结点个数+右子树结点个数+1
    //终止条件：空树 0；一个子结点的树 1(可选)
    private static int count(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = count(root.left);
            int right = count(root.right);
            return left + right + 1;
        }
    }

    /**
     * 求二叉树叶子节点的个数
     * 递归思想：总的叶结点个数=左子树叶结点个数+右子树叶节点个数
     * 终止条件：空树 0；没有左子树与右子树 1
     *
     * @param root
     * @return
     */
    private static int leafCount(Node root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return leafCount(root.left)+leafCount(root.right);
    }

    /**
     * 二叉树的高度
     * 递归思想：二叉树的高度=左子树的高度与右子树的高度的最大值+1
     * 终止条件：空树的高度为0
     *
     * @param root
     * @return
     */
    private static int height(Node root) {
        if(root==null){
            return 0;
        }
        return (height(root.left)>height(root.right)?height(root.left):height(root.right))+1;
        //优化
//        return java.lang.Math.max(height(root.left),height(root.right))+1;
    }

    /**
     * 第k层的结点数
     * 递归思想：根结点的第k层的结点数=根结点左子树的第k-1层的结点数+根结点右子树的第k-1层的结点数
     * 终止条件：空树 0；第1层 1
     *
     * @param root
     * @param k
     * @return
     */
    private static int kLevel(Node root, int k) {
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return kLevel(root.left,k-1)+kLevel(root.right,k-1);
    }

    /**
     * 在二叉树中查找一个值，找到，返回结点；未找到，返回null
     * 递归思想：先查看根结点，没有则查看左子树，还没有查看右子树
     * 终止条件：根结点等于给定值，返回根结点
     * @param root
     * @param v
     * @return
     */
    private static Node find(Node root, char v) {
        if(root==null){
            return null;
        }
        if(root.value==v){
            return root;
        }
        Node r=find(root.left,v);
        if(r!=null){
            return r;
        }
        //根结点和左子树都没有，不论右子树中有没有都返回查找右子树的返回值
        return find(root.right,v);
    }

    private static Node createTestTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;

        return a;
    }

    public static void main(String[] args) {
        Node root = createTestTree();
//        preOrderTraversal(root);
//        System.out.println();
//        inOrderTraversal(root);
//        System.out.println();
//        postOrderTraversal(root);
//        System.out.println();
//
//        System.out.println("二叉树高度: " + height(root));
//        System.out.println(leafCount(root));
//        System.out.println(count(root));
        System.out.println(find(root,'F'));
    }

}
