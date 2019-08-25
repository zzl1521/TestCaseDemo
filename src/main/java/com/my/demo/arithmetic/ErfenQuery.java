package com.my.demo.arithmetic;

/**
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/28 15:37
 */
public class ErfenQuery {

    private static int[] arr = new int[]{1, 2, 4, 5};


    public static int queryEr(int num) {
        int index = 0;
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            index = lo + (hi - lo) / 2; //如果是右移运算符必须括号括起来 lo + ((hi - lo) >> 1)
            if (arr[index] == num) {
                return index;
            }
            if (arr[index] < num) {
                lo = index + 1;
            }
            if (arr[index] > num) {
                hi = index - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(queryEr(4));
    }
}
