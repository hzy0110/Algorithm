package com.hzy.test;

import static com.hzy.exercise.ChapterTwo.exch;
import static com.hzy.exercise.ChapterTwo.less;

/**
 * Created by Hzy on 2016/5/12.
 */
public class Shell {
    public static void sort(Comparable[] a)
    { // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1)
        { // 将数组变为h有序
            for (int i = h; i < N; i++)
            { // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h= h/3;
        }
    }
}
