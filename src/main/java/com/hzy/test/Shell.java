package com.hzy.test;

import static com.hzy.exercise.ChapterTwo.exch;
import static com.hzy.exercise.ChapterTwo.less;

/**
 * Created by Hzy on 2016/5/12.
 */
public class Shell {
    public static void sort(Comparable[] a)
    { // ��a[]����������
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1)
        { // �������Ϊh����
            for (int i = h; i < N; i++)
            { // ��a[i]���뵽a[i-h], a[i-2*h], a[i-3*h]... ֮��
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h= h/3;
        }
    }
}
