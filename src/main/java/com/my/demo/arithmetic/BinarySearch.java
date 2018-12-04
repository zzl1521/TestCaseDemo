package com.my.demo.arithmetic;

/**
 * ���ֲ��ң���������ֵ���ң�
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/29 16:48
 */
public class BinarySearch {


    /**
     * ���ҵ�һ�����ڸ���ֵ
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int firstGreaterThan(int[] arr, int num) {
        int low = 0;
        int hi = arr.length - 1;
        while (low <= hi) {
            int index = low + ((hi - low) / 2);
            if (arr[index] <= num) {
                low = index + 1;
            }
            if (arr[index] > num) {
                if (index == 0 || arr[index - 1] <= num) return index;
                else hi = index - 1;
            }
        }
        return -1;
    }


    /**
     * �������һ�����ڸ���ֵ
     * TODO ������
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int lastGreaterThan(int[] arr, int num) {
        int low = 0;
        int hi = arr.length - 1;
        while (low <= hi) {
            int index = low + ((hi - low) >> 1);
            if (arr[index] <= num) {
                low = index + 1;
            }
            if (arr[index] > num) {
                if (arr[index - 1] <= num && arr[index] < arr[index + 1]
                        || arr[index - 1] == arr[index]) return index;
                else hi = index - 1;
            }
        }
        return -1;

    }


    /**
     * ���ҵ�һ�����ڸ���ֵ
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int firstEqualsThan(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int index = low + ((high - low) >> 1);
            if (arr[index] > num) {
                high = index - 1;
            }
            if (arr[index] < num) {
                low = index + 1;
            }
            if (arr[index] == num && arr[index - 1] < num) {
                return index;
            }

        }
        return -1;
    }


    /**
     * 4 5 6 1 2 3
     * ѭ������Ķ��ֲ���
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int forEqualsThan(int[] arr, int num) {
        if (arr[0] == num) {
            return 0;
        }
        int length = arr.length;
        int low = 0;
        int high = length - 1;
        //�ҵ�ѭ���ڵ�
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                if (arr[i] > arr[0]) {
                    low = i;
                    high = 0;
                    break;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    low = i;
                    high = low + 1;
                    break;
                }
            }
        }
        //�жϵ�һ���ڵ�Ĵ�Сλ�ã�ȷ��low��high��ֵ��ת��Ϊ��������Ķ��ֲ���
        if (arr[0] < num) {
            high = low;
            low = 0;
        }
        if (arr[0] > num) {
            low = high;
            high = length - 1;
        }
        while (low <= high) {
            int index = low + ((high - low) >> 1);
            if (arr[index] > num) {
                high = index - 1;
            }
            if (arr[index] < num) {
                low = index + 1;
            }
            if (arr[index] == num) {
                return index;
            }
        }
        return -1;
    }


    //�������һ��С�ڵ��ڸ���ֵ��Ԫ��

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9};
        System.out.println(firstGreaterThan(arr, 5));
        System.out.println(lastGreaterThan(arr, 5));
        System.out.println(firstEqualsThan(arr, 6));
        int[] arr1 = {2, 3, 4, 5, 6, 8, 9, 1};
        System.out.println("----------\n" + forEqualsThan(arr1, 5));
        System.out.println(forEqualsThan(arr1, 6));
        System.out.println(forEqualsThan(arr1, 8));
        System.out.println(forEqualsThan(arr1, 9));
        System.out.println(forEqualsThan(arr1, 1));
        System.out.println(forEqualsThan(arr1, 2));
        System.out.println(forEqualsThan(arr1, 3));
        System.out.println(forEqualsThan(arr1, 4));
    }

}
