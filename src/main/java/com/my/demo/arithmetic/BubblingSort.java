package com.my.demo.arithmetic;

/**
 * ð������
 *
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/26 16:48
 */
public class BubblingSort {

    private static int[] arr = new int[]{5, 2, 1, 6, 7,0,12,2,55,12};

    /**
     * ð������
     * �߼��� ���Ӷ�ΪO(n2) ,ÿ��ѭ�������Աȣ� i>i+1��������н���������һ��ÿ�ζ����ҵ���N���ֵ������ͻ������ˣ��´���ѭ���ȽϾ�����һ����
     * �Ż��㣺 ÿ��ѭ������Ƿ��л�������������û�оͿ���break�ˣ�˵���Ѿ��ź����ˣ�������ѭ��ʣ��Ĵ���
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/26 17:26
     * @param:
     */
    public static void sort() {
        int base;
        for (int i = 0; i < arr.length; i++) {//ð�ݵĴ���
            for (int j = 0; j < arr.length-i-1; j++) {
                base=arr[j];
                if (arr[j] > arr[j+1]) {
                    arr[j] = arr[j+1];
                    arr[j+1]=base;
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
