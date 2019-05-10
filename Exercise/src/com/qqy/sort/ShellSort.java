package com.qqy.sort;

/**
 * 希尔排序
 * 思路：
 *      1. 将一组记录按照gap分组，将每组中的数据进行直接插入排序
 *      2. 缩小gap -> 1
 *      3. 直到gap==1
 * gap：
 *      1.gap = length
 *      2.gap = (gap/3)+1 或者 gap=gap/2
 * Author:qqy
 */
public class ShellSort {
    private static void insertSortWithGap(int[] array, int gap) {
        for(int i=0;i<array.length;i++){
            int val=array[i];
            int j;
            for(j=i-gap;j>=0 && array[j]>array[i];j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=val;
        }
    }

    public static void shellSort(int[] array){
        int gap=array.length;
        while(true){
            gap=(gap/3)+1;
            insertSortWithGap(array,gap);
            if(gap==1){
                break;
            }
        }
    }
}
