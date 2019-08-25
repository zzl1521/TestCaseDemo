package com.my.demo.arithmetic;

/**
 * 冒泡排序
 *
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/26 16:48
 */
public class BubblingSort {

    private static int[] arr = new int[]{5, 2, 1, 6, 7, 0, 12, 2, 55, 12};

    /**
     * 冒泡排序
     * 逻辑： 复杂度为O(n2) ,每次循环两两对比， i>i+1的情况进行交换，这样一来每次都能找到第N大的值（后面就会有序了，下次再循环比较就能少一个）
     * 优化点： 每次循环检查是否有互换的情况，如果没有就可以break了，说明已经排好序了，不用再循环剩余的次数
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/26 17:26
     * @param:
     */
    public static void sort() {
        int base;
        for (int i = 0; i < arr.length; i++) {//仅仅代表冒泡的次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                base = arr[j];
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = base;
                }
            }
        }
    }


    public static void main(String[] args) {
        sort();
        for (int num : arr)
            System.out.println(num);
    }

}
