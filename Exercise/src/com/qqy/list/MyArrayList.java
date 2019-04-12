package com.qqy.list;

/**
 * 顺序表的增删
 * Author:qqy
 */
public class MyArrayList implements IArrayList {
    //ArrayList -> 底层使用数组实现
    //保存数据的空间
    private int[] array;
    //保存有效数据的个数
    private int size;

    MyArrayList(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    @Override
    public void pushFront(int item) {
        for (int i = this.size; i >= 1; i--) {
            this.array[i] = array[i - 1];
        }
        this.array[0] = item;
        this.size++;
    }

    @Override
    public void pushBack(int item) {
        this.array[this.size] = item;
        this.size++;
    }


    @Override
    public void add(int item, int index) {
        if (index < 0 || index >= this.size) {
            throw new Error();
        }
        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = item;
        this.size++;
    }

    @Override
    public void popFront() {
        if (this.size == 0) {
            throw new Error();
        }
        for (int i = 0; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[--this.size] = 0;
    }

    @Override
    public void popBack() {
        if (this.size != 0) {
            this.array[--this.size] = 0;
        } else {
            throw new Error();
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new Error();
        }
        if (this.size == 0) {
            throw new Error();
        }
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
    }

    private void ensureCapacity(){
        if(this.size<this.array.length){
            return;
        }

        //1.
        int capacity=this.array.length*2;
        int [] newArray=new int[capacity];
        //2.
        for(int i=0;i<this.size;i++){
            newArray[i]=this.array[i];
        }
        //3.
        this.array=newArray;
    }

    public void pushFront1(int v){
        if(size==array.length){
            //开辟新空间
            int capacity=this.array.length*2;
            int[] newArray=new int[capacity];
            //搬家
            for(int i=0;i<this.size;i++){
                newArray[i]=this.array[i];
            }
            //告知信息
            this.array=newArray;
        }
        for(int i=this.size;i>0;i--){
            this.array[i]=this.array[i-1];
        }
        this.array[0]=v;
        size++;
    }
}
