package com.my.demo.arithmetic;

/**
 * ��������
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/20 11:41
 */
public class InsertSort {


    private static int[] arr = new int[]{1, 5, 2, 7, 2, 8, 3, 4, 6,23,0,1246,50,22,10,9};


    /**
     * ��������
     * �ӵ����������Աȣ�Ȼ��ѭ��������߼���
     * �����߼��� �ڶ�����С�ڵ������������ڶ���������ƶ�һλ��ͬʱ���ڶ��������±��¼��������׼�����ŵ���������ֵ
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/26 14:41 
     * @param: 
     */
    public static void insertSort() {
        for (int i=2;i<arr.length;i++){
            int key=arr[i];//��ǰ�Ƚϵ�ֵ
            int point=i;//���Բ���ĵ�
            for(int j=i-1;j>=0;j--){ //�ڶ�����С�ڵ������������ڶ���������ƶ�һλ��ͬʱ���ڶ��������±��¼��������׼�����ŵ���������ֵ
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
