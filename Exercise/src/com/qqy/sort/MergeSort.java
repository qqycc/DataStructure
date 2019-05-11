package com.qqy.sort;

/**
 * 归并排序
 * Author:qqy
 */
public class MergeSort {
    public static void mergeSort(int[] array) {
        int[] extra = new int[array.length];
        //左闭右开
        mergeSortInner(array, 0, array.length, extra);
    }

    //非递归
    public static void mergeSortNorR(int[] array) {
        int[] extra = new int[array.length];
        for(int i=1;i<array.length;i*=2){
            for(int j=0;j<array.length;j+=2*i){
                int low=j;

                int mid=j+i;
                //若没有右区间
                if(mid>array.length){
                    mid= array.length;
                }

                int high=mid+i;
                //若右区间越界
                if(high>array.length){
                    high= array.length;
                }
                merge(array,low,mid,high,extra);
            }
        }
    }

        public static void mergeSortInner(int[] array, int low, int high, int[] extra) {
        if (low >= high - 1) {
            return;
        }
        int mid = low + (high - low) / 2;

        //左区间 [low,mid)   有区间 [mid,high)
        mergeSortInner(array, low, mid, extra);
        mergeSortInner(array, mid, high, extra);

        //合并两个有序区间
        merge(array, low, mid, high, extra);
    }

    public static void merge(int[] array, int low, int mid, int high, int[] extra) {
        int left = low;
        int right = mid;
        //x标记额外空间的下标
        int x = 0;
        while (left < mid && right < high) {
            if (array[left] <= array[right]) {
                extra[x++] = array[left++];
            } else {
                extra[x++] = array[right++];
            }
        }

        //若第一个区间有剩余，直接加入
        while (left < mid) {
            extra[x++] = array[left++];
        }
        //第二个队列有剩余
        while (right < high) {
            extra[x++] = array[right++];
        }

        //返还给原数组
        for (int k = low; k < high; k++) {
            array[k] = extra[k - low];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 7, 56, 1, 2, 4, 7, 9};
//        mergeSort(arr);
        mergeSortNorR(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
