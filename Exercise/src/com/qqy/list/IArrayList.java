package com.qqy.list;

/**
 * 顺序表
 * Author:qqy
 */
public interface IArrayList {
    /**
     * 将数据item插入至顺序表的表头
     * @param item 插入数据
     */
    //应该使用泛型，而不是int
    void pushFront(int item);

    /**
     * 将数据item插入至顺序表的表尾
     * @param item
     */
    void pushBack(int item);

    /**
     * 将数据item插入之index下标位置处，index后的数据后移
     * @param item
     * @param index
     */
    void add(int item,int index);

    /**
     * 删除表头数据
     */
    void popFront();

    /**
     * 删除表尾数据
     */
    void popBack();

    /**
     * 删除index下标位置处的数据，index后的数据前移
     * @param index
     */
    void remove(int index);
}
