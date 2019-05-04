package com.qqy.tree;

/**采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点用一对空括号 "()" 表示。
 * 省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对
 *    即：左右子树都为空，省略，写根即可
 *       左空，右不空，左边的()不能省略
 *       右空，左不空，右边的()可以省略
 * 思路：
 *      1.若为空树，则返回空字符串""
 *      2.前序遍历
 *          由括号的需求可得，只需要对左空右不空的情况进行特殊处理即可
 *              若左空右不空，则遍历中加一个()
 *      3.由于最外层不需要括号，因此，删除第一个和最后一个元素
 * Author:qqy
 */
public class TreeStr {
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

    public String tree2str(Node t) {
        if(t==null){
            return "";
        }
        StringBuilder str=new StringBuilder();
        preOrder(t,str);
        str.delete(0,1);
        str.delete(str.length()-1,str.length());
        return str.toString();
    }

    public StringBuilder preOrder(Node t,StringBuilder str){
        if(t!=null) {
            str.append("(");
            str.append(t.value);
            if (t.left == null & t.right != null) {
                str.append("()");
            } else {
                preOrder(t.left, str);
            }
            preOrder(t.right, str);
            str.append(")");
        }
        return str;
    }
}
