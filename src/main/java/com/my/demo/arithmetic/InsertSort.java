package com.my.demo.arithmetic;

/**
 * 插入排序
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/20 11:41
 */
public class InsertSort {


    private static int[] arr = new int[]{1, 5, 2, 7, 2, 8, 3, 4, 6,23,0,1246,50,22,10,9};


    /**
     * 插入排序
     * 从第三个数开对比，然后循环下面的逻辑：
     * 具体逻辑： 第二个数小于第三个数，将第二个数向后移动一位，同时将第二个数的下标记录下来，“准备”放第三个数的值
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/26 14:41 
     * @param: 
     */
    public static void insertSort() {
        for (int i=2;i<arr.length;i++){
            int key=arr[i];//当前比较的值
            int point=i;//可以插入的点
            for(int j=i-1;j>=0;j--){ //第二个数小于第三个数，将第二个数向后移动一位，同时将第二个数的下标记录下来，“准备”放第三个数的值
                if (key<arr[j]){
                    arr[j+1]=arr[j];
                    point=j;
                }
            }
            arr[point]=key;
        }
        for (int s : arr)
            System.out.println(s);
    }

    public static void main(String[] args) {
        insertSort();
    }
}
