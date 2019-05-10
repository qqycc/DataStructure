package com.qqy.sort;

/**
 * 选择排序
 * 思路：
 *      无序部分[0,array.length-i)
 *      有序部分[array.length-i,array.length)
 *       1.遍历数组
 *       2.遍历找出无序部分最大数的下标
 *       3.将该数与无序部分的最后一个数进行交换
 * Author:qqy
 */
public class SelectSort {
    //选择排序
    public static void selectSort(int[] array) {
        for(int i=0;i<array.length;i++){
            int max=0;
            //找出最大值
            for(int j=1;j<array.length;i++){
                if(array[max]<array[j]){
                    //不需要交换值，只需要记录最大值的位置就好
                    j=max;
                }
            }
            int t=array[max];
            array[max]=array[array.length-i-1];
            array[array.length-i-1]=t;
        }
    }
}
