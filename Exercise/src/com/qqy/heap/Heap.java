package com.qqy.heap;

/**
 * 堆化与建堆
 * Author:qqy
 */
public class Heap {
    /**
     * 完全二叉树堆化(向下调整）
     * 思路(以最大堆为例)：
     *      1.先判断是否为叶子结点
     *      2.因为不是叶子节点就一定有左孩子，只需判断是否存在右孩子，并找到两者间的最大值
     *          a.没有右孩子   max：左孩子
     *          b.有右孩子
     *              右大      max：右孩子
     *              左大      max：左孩子
     *      3.max与根的值比较
     *          a.根大    不调整
     *          b.max大   交换两者
     *      4.继续调整
     * @param tree
     * @param size
     * @param index
     */

    /**
     * 已知位置堆化
     */
    public static void heapify(int[] tree, int size, int index) {
        int left = 2 * index + 1;
        if (left >= size) {
            return;
        }

        int right = 2 * index + 2;
        int max = left;
        if (right < size && tree[right] > tree[left]) {
            max = right;
        }

        if (tree[index] >= tree[max]) {
            return;
        }

        // 根的值比较小，先交换
        int t = tree[index];
        tree[index] = tree[max];
        tree[max] = t;

        // 继续向下调整
        heapify(tree, size, max);
    }

    /**
     * 未知位置，从根节点开始，最大堆递归
     * @param tree
     * @param size
     * @param index
     */
    public static void heapifyMax(int[] tree, int size, int index) {
        //1.
        int left=index*2+1;
        //没有左孩子
        if(left>=size){
            return ;
        }

        //2.
        int right=index*2+2;
        int max=left;
        //有右孩子，且右孩子大
        if(right<size && tree[right]>tree[left]){
            max=right;
        }

        //3.
        if(tree[max]>tree[index]){
            int t = tree[index];
            tree[index] = tree[max];
            tree[max] = t;
        }
        index++;
        //4.
        heapifyMax(tree,size,index);
    }

    /**
     * 未知位置，从根节点开始，最大堆循环
     * @param array
     * @param size
     * @param index
     */
    public static void adjustDownMax(int[] array, int size, int index) {
        //不是叶子节点就一直循环
        int max=index*2+1;
        while(max<size){
            //若右孩子存在且大
            if(max+1<size && array[max+1]>array[max]){
                max+=1;
            }

            if(array[index]>array[max]){
                index++;
                max=index*2+1;
                continue;
            }

            int t=array[index];
            array[index]=array[max];
            array[max]=t;
            index++;
            max=index*2+1;
        }
    }

    /**
     * 未知位置，从根节点开始，最小堆循环
     * @param tree
     * @param size
     * @param index
     */
    public static void adjustDownMin(int[] tree, int size, int index) {
        int min=index*2+1;
        while(min<size){

            if(min+1<size && tree[min+1]<tree[min]){
                min+=1;
            }
            if(tree[index]<tree[min]){
                index++;
                min=index*2+1;
                continue;
            }
            int t=tree[index];
            tree[index]=tree[min];
            tree[min]=t;
            min=index*2+1;
        }
    }

    /**
     * 未知位置，从根节点开始，最小堆递归
     * @param tree
     * @param size
     * @param index
     */
    public static void heapifyMin(int[] tree, int size, int index) {
        int left=index*2+1;
        if(left>=size){
            return;
        }
        int right=index*2+2;
        int min=left;
        if(right<size && tree[right]<tree[left]){
            min=right;
        }
        if(tree[min]<tree[index]){
            int t=tree[index];
            tree[index]=tree[min];
            tree[min]=t;
        }
        index++;
        heapifyMin(tree,size,index);
    }

    /**
     * 向上调整
     */

    /**
     * 已知位置，堆化为最大堆
     * @param array
     * @param size
     * @param index
     */
     public static void adjustUp(int[] array, int size, int index) {
         while(index>0){
             int parent=(index-1)/2;
             if(array[parent]>=array[index]){
                 break;
             }
             int t=array[parent];
             array[parent]=array[index];
             array[index]=t;

             index=parent;
         }
     }

    /**
     * 建堆(最大堆)
     * 思路：
     *      从最后一个非叶子节点开始堆化，直到根节点
     * @param array
     * @param size
     */
    public static void createHeap(int[] array,int size) {
        for(int i=(array.length-2)/2;i>=0;i--){
            heapify(array,size,i);
        }
    }
}
