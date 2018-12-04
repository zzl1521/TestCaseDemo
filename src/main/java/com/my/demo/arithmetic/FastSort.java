package com.my.demo.arithmetic;

/**
 * ��������
 *
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/20 11:41
 */
public class FastSort {

    private static int[] arr = new int[]{1, 5, 2};


    public static int partition(int[] array, int lo, int hi) {
        //�̶����зַ�ʽ
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//�Ӻ�벿����ǰɨ��
                hi--;
            }
            array[lo] = array[hi];  //2  2
            while (array[lo] <= key && hi > lo) {//��ǰ�벿�����ɨ��
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
