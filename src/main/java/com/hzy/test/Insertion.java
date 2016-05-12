package com.hzy.test;

import static com.hzy.exercise.ChapterTwo.exch;
import static com.hzy.exercise.ChapterTwo.less;
import static com.hzy.exercise.ChapterTwo.printComprable;

/**
 * Created by Hzy on 2016/5/9.
 */
public class Insertion {
    public static void sort(Comparable[] a)
    { // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++)
        { // 将 a[i] 插入到 a[i-1]、 a[i-2]、 a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                //printComprable(a);
                exch(a, j, j - 1);
            }
        }
    } // less()、 exch()、 isSorted()和main()方法见“ 排序算法类模板”
}

