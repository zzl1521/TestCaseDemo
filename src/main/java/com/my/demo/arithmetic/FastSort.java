package com.my.demo.arithmetic;

/**
 * 快速排序
 * 快排的思路：取数组中的一个值key，分别判断
 *
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/20 11:41
 */
public class FastSort {

    private static int[] arr = new int[]{1, 5, 2};


    public static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];  //2  2
            while (array[lo] <= key && hi > lo) {//从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    public static void main(String[] args) {
        sort(arr, 0, arr.length - 1);
        for (int num : arr)
            System.out.println(num);
    }

}
