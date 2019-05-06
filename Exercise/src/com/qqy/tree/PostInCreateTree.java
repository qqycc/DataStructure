package com.qqy.tree;

import java.util.Arrays;

/**
 * 后序+中序创建二叉树
 * Author:qqy
 */
public class PostInCreateTree {
    private class Node {
        int value;
        //左子树
        Node left;
        //右子树
        Node right;

        Node(int v) {
            this.value = v;
        }
    }

    public Node buildTree(int[] inOrder, int[] postOrder) {
        //终止条件
        if (inOrder.length == 0) {
            return null;
        }

        //取得根结点
        Node root = new Node(postOrder[postOrder.length - 1]);
        //查找根结点在中序的位置
        int index = find(inOrder, root.value);

        //切分左子树
        int[] leftin = Arrays.copyOfRange(inOrder, 0, index);
        int[] leftpost = Arrays.copyOfRange(postOrder, 0, index);
        root.left = buildTree(leftin, leftpost);

        //切分右子树
        int[] rightin = Arrays.copyOfRange(inOrder, index + 1, inOrder.length);
        int[] rightpost = Arrays.copyOfRange(postOrder, index, postOrder.length - 1);
        root.right = buildTree(rightin, rightpost);

        return root;
    }

    public int find(int[] array, int v) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
