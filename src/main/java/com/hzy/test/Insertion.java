package com.hzy.test;

import static com.hzy.exercise.ChapterTwo.exch;
import static com.hzy.exercise.ChapterTwo.less;
import static com.hzy.exercise.ChapterTwo.printComprable;

/**
 * Created by Hzy on 2016/5/9.
 */
public class Insertion {
    public static void sort(Comparable[] a)
    { // ��a[]����������
        int N = a.length;
        for (int i = 1; i < N; i++)
        { // �� a[i] ���뵽 a[i-1]�� a[i-2]�� a[i-3]...֮��
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                //printComprable(a);
                exch(a, j, j - 1);
            }
        }
    } // less()�� exch()�� isSorted()��main()�������� �����㷨��ģ�塱
}

