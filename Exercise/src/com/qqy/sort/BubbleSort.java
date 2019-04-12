package com.qqy.sort;

/**
 * 冒泡排序
 * Author:qqy
 */
public class BubbleSort {
    public static void bubbleSort(int[] array) {
        //假设有序
        boolean flag = true;
        //外部循环一共需要n-1次冒泡排序
        for (int i = 0; i < array.length - 1; i++) {
            //外部循环第i次需要比较n-2-i次
            for (int j = 0; j < array.length - 1 - i; j++) {
                //将两个数字中较大的置后
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;

                    //进入到if中，则表明有数字进行交换,无序
                    flag = false;
                }
            }
            //有序，退出循环
            if (flag == true) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 6, 2, 1, 4, 7, 9, 3};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
