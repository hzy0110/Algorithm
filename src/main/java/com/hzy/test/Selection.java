package com.hzy.test;


import static com.hzy.exercise.ChapterTwo.*;

/**
 * Created by Hzy on 2016/5/10.
 */
public class Selection {
    public static void sort(Comparable[] a)
    { // ��a[]����������
        int N = a.length; // ���鳤��
        for (int i = 0; i < N; i++)
        { // ��a[i]��a[i+1..N]����С��Ԫ�ؽ���
            int min = i; // ��СԪ�ص�����
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            printComprable(a);
            exch(a, i, min);


        }

    }


    // less()�� exch()�� isSorted()��main()�������� �����㷨��ģ�塱
}
