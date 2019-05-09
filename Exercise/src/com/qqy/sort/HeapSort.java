package com.qqy.sort;

/**
 * 堆排序
 * 思路：
 *      无序部分[0,array.length-i)
 *      有序部分[array.length-i,array.length)
 *      1.建最大堆
 *      2.将最大值取出放至数组最后，将无序部分的最后一个数置于根节点
 *      3.堆化 -> 2
 * Author:qqy
 */
public class HeapSort {
    //堆排序
    public static void heapSort(int[] array) {
        //向上建大堆
        createHeap(array);
        for(int i=0;i<array.length;i++) {
            int t = array[0];
            array[0] = array[array.length - i - 1];
            array[array.length-i-1]=t;
            heapify(array,array.length-i-1,0);
        }
    }

    public static void heapSort1(int[] array) {
        createHeap(array);
        for(int i=array.length-1;i>0;i--){
            int t=array[i];
            array[i]=array[0];
            array[0]=t;
            heapify(array,i,0);
        }
    }

    public static void heapify(int[] array, int size, int index) {
        while(2*index+1<size){
            int max=2*index+1;
            if(max+1<size && array[max+1]>array[max]){
                max+=1;
            }
            if(array[max]<=array[index]){
                break;
            }
            int t=array[max];
            array[max]=array[index];
            array[index]=t;

            index=max;
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }


    public static void main(String[] args) {
        int[] arr=new int[]{20,8,5,6,5,8,5,2,12,85,9,5,4,7,8,2,1,3,6};
        heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
