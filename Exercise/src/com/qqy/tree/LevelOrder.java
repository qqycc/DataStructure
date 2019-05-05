package com.qqy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。
 * （逐层地，从左到右访问所有节点）
 * 思路：
 *      1.创建一个NodeLevel类，存放节点和层数
 *      2.使用List<List<Integer>>类型创建的list来存储结果，类似于{{}{}{}}
 *      3.若为空树，直接返回{}
 *      4.创建一个LinkedList类型的队列，用于存放与取出节点
 *      5.将根节点存入队列
 *      6.若队列不为空，一直循环操作
 *        a.取出根节点
 *        b.若层数等于list.size()，即大括号中的第几个小括号
 *              则新建一个小括号，并将节点放入
 *          否则，直接将节点放入
 *        c.当根节点的左孩子不为空时，存入左孩子，层数加1
 *        d.当根节点的右孩子不为空时，存入右孩子，层数加1
 * Author:qqy
 */
public class LevelOrder {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list; //{}
        }

        class NodeLevel{
            int level;
            Node node;

            NodeLevel(Node node,int level){
                this.node=node;
                this.level=level;
            }
        }

        //建一个队列
        LinkedList<NodeLevel> queue=new LinkedList<>();
        //将根结点放入队列
        queue.addLast(new NodeLevel(root,0));
        while(!queue.isEmpty()){
            NodeLevel out=queue.pollFirst();
            //弹出的节点
            Node node=out.node;
            //弹出的层
            int level=out.level;
            if(list.size()==level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.value);

            if(node.left!=null){
                queue.addLast(new NodeLevel(node.left,level+1));
            }
            if(node.right!=null){
                queue.addLast(new NodeLevel(node.right,level+1));
            }
        }
        return list;
    }
}
