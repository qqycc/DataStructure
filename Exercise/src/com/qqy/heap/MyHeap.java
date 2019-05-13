package com.qqy.heap;


/**
 * 堆
 * Author:qqy
 */
public class MyHeap {
    private int[] array;
    private int size;

    MyHeap(int[] array){
        this.array=new int[1024];
        for(int i=0;i<array.length;i++){
            this.array[i]=array[i];
        }
        this.size=array.length;
        Heap.createHeap(this.array,this.size);
    }

    /**
     * 获取堆中最大值
     * @return
     */
    public int top(){
        return array[0];
    }

    /**
     * 获取最大值并删除
     * 思路：
     *      取走最大值后，将最后一个节点置于根节点处，进行堆化
     * @return
     */
    public int pop(){
        int v=array[0];
        array[0]=array[size-1];
        size--;

        Heap.heapifyMax(array,size,0);
        return v;
    }

    /**
     * 插入一个值
     * 思路：
     *      将该值插到最后，向上调整
     * @param v
     */
    public void push(int v){
        array[size++]=v;
        Heap.adjustUpMax(array,size,size-1);
    }
}
