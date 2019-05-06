package com.qqy.tree;

import java.util.Arrays;

/**
 * 前序+中序创建二叉树
 * Author:qqy
 */
public class PreInCreateTree {
    public class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
        }
    }

    public int find(int[] array,int v){
        for(int i=0;i<array.length;i++){
            if(array[i]==v){
                return i;
            }
        }
        return -1;
    }

    public Node preInCreateTree(int[] preOrder,int[] inOrder){
        //终止条件
        //前序和中序的长度适中相同，因此，其中一个为空，都为空。
        //为空，视为空树
        if(preOrder.length==0){
            return null;
        }

        //根据前序找到并创建根结点
        Node root=new Node(preOrder[0]);
        //在inOrder中找到root的下标
        int index=find(inOrder,root.value);

        //切出左子树的前序+中序
        //由于to排他，因此和步骤中的不同，需要+1
        int[] leftPre=Arrays.copyOfRange(preOrder,1,index+1);
        int[] leftIn=Arrays.copyOfRange(inOrder,0,index);
        root.left=preInCreateTree(leftPre,leftIn);

        //切出右子树
        int[] rightPre=Arrays.copyOfRange(preOrder,1+index,preOrder.length);
        int[] rightIn=Arrays.copyOfRange(inOrder,index+1,inOrder.length);
        root.right=preInCreateTree(rightPre,rightIn);

        return root;
    }
}
