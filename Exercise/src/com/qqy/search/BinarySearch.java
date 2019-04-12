package com.qqy.search;

/**
 * 二分查找
 * Author:qqy
 */
public class BinarySearch {
    public int BinarySearch(int[] array,int value){
        //左闭右闭
        int left=0;
        int right=array.length-1;
        while(left<=right) {
            int mid=(right-left)/2+left;
            if (mid > value) {
                right = mid - 1;
            } else if (mid < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        //找不到，返回-1
        return -1;
    }
}
