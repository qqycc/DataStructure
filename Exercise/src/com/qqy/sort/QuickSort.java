package com.qqy.sort;

/**
 * 快速排序
 * Author:qqy
 */
public class QuickSort {
    public static void quickSort(int[] array,int left,int right){
        if(left>=right){
            return;
        }

        int pivot=theMiddleOfThreeNumbers(array,left,right);
        swap(array,right,pivot);

        //获取每次排序后，基准值的位置
        int pivotIndex=partitionIndex(array,left,right);
//        int pivotIndex=partitionHover(array,left,right);
//        int pivotIndex=partitionPit(array,left,right);

        //小于基准值区间[left,pivotIndex-1]
        quickSort(array,left,pivotIndex-1);
        //大于基准值区间[pivotIndex+1,right]
        quickSort(array,pivotIndex+1,right);
    }

    //分区方法 -> hover
    public static int partitionHover(int[] array,int left,int right){
        int begin=left;
        int end=right;
        int pivot=array[right];
        //直到两者相遇
        while(begin<end) {
            while (begin<end && array[begin] <= pivot) {
                begin++;
            }
            while (begin<end && array[end] >= pivot) {
                end--;
            }
            swap(array,begin,end);
        }
        swap(array,begin,right);
        return begin;
    }
    public static void swap(int[] array,int a,int b){
        int t=array[a];
        array[a]=array[b];
        array[b]=t;
    }

    //分区方法 -> 挖坑
    public static int partitionPit(int[] array,int left,int right){
        int begin=left;
        int end=right;
        int pivot=array[right];
        while(begin<end){
            while(begin<end && array[begin]<=pivot){
                begin++;
            }
            array[end]=array[begin];
            while(begin<end && array[end]>=pivot){
                end--;
            }
            array[begin]=array[end];
        }
        array[begin]=pivot;
        return begin;
    }

    //分区方法 -> 前后下标
    public static int partitionIndex(int[] array,int left,int right){
        int small=left;
        int big=left;
        int pivot=array[right];
        while(big<right) {
            if (array[big] < pivot) {
                swap(array, small, big);
                small++;
            }
            big++;
        }
        swap(array,small,right);
        return small;
    }

    //三数取中法
    public static int theMiddleOfThreeNumbers(int[] array,int left,int right){
        int mid=left+(right-left)/2;
        if(array[left]<array[right]){
            if(array[left]>array[mid]){
                return left;
            }else if(array[right]<array[mid]){
                return right;
            }
        }else{
            if(array[left]<array[mid]){
                return left;
            }else if(array[right]>array[mid]){
                return right;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,8,7,56,1,2,4,7,9};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
