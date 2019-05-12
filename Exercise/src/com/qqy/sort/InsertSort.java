package com.qqy.sort;

/**
 * 插入排序
 * 思路：
 *      设有序部分的最后一个下标为j，所要插入的数的下标为i。
 *      有序部分[0，i)
 *      无序部分[i,array.length)
 *      1. 在有序部分，查找合适的位置
 *         合适的位置存在3种情况
 *            1) a[ i ] > a[ j ]        找到合适的位置
 *            2) a[ i ] == a[ j ]       为了保证稳定性，认为找到合适的位置
 *            3) a[ i ] < a[ j ]        j--
 *         1.1 遍历查找
 *              从前往后
 *              从后往前
 *         1.2 二分查找
 *              左闭右开查找,只需要对有序部分进行二分。且left==right时，区间中没有值。
 *              left=0  right=i  mid=left+(right-left)/2
 *      2. 将指定的数插入到合适的下标处
 *         2.1 遍历查找的插入过程
 *             插入的位置：j+1
 *             插入的过程相当于
 *               给定 pos 的顺序表做插入
 *         2.2 二分查找的插入过程
 *             要插入数字a[i]与a[mid]的关系
 *                1) a[mid]==a[i] / a[mid]<a[i]  left=mid+1
 *                2) a[mid]>a[i]    right=mid
 *             插入位置：left
 * Author:qqy
 */
public class InsertSort {
    /**
     * 遍历查找
     * 先找位置后插入
     * @param array
     */
    public static void insertSort(int[] array){
        for(int i=0;i<array.length;i++){
            int val=array[i];
            //在有序位置从后向前遍历查找
            int j;
            for(j=i-1;j>=0 && array[i]<array[j];j--){
            }

            //在j+1处插入
            for(int k=i;k>j+1;k--){
                array[k]=array[k-1];
            }
            array[j+1]=val;
        }
    }

    /**
     * 遍历查找
     * 边找位置边插入
     * @param array
     */
    public static void insertSort2(int[] array){
        for(int i=0;i<array.length;i++) {
            int val = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > array[i]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = val;
        }
    }

    /**
     * 二分查找
     * @param array
     */
    public static void insertSort3(int[] array){
        for(int i=0;i<array.length;i++){
            int val=array[i];
            int left=0;
            int right=i;
            while(left<right){
                int mid=left+(right-left)/2;
                if(array[mid]>array[i]){
                    right=mid;
                }else {
                    left=mid+1;
                }
            }
            for(int k=i;k>left;k--){
                array[k]=array[k-1];
            }
            array[left]=val;
        }
    }

}
