package com.hzy.exercise;

import com.hzy.test.Insertion;
import com.hzy.test.Selection;
import com.hzy.test.Shell;
import com.hzy.util.StdOut;
import com.hzy.util.StdRandom;
import com.hzy.util.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zy on 2016/5/3.
 */
public class ChapterTwo {

    private static final Logger logger = LoggerFactory.getLogger(ChapterTwo.class);

    public static void main(String args[]) {
        int l = 10000;
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};

        String[] b = new String[l];
        for (int i = 0; i < l; i++) {
            b[i] = "X";
        }

        Double[] c = new Double[l];
        for (int i = 0; i < l; i++) {
            c[i] = (double) l-i;
        }

        double t1 = time("Insertion", c);
        double t2 = time("Selection", c);
        System.out.println("Insertion time=" + t1);
        System.out.println("Selection time=" + t2);

        //Selection.sort(a);
        //Insertion.sort(a);
        assert isSorted(a);
        show(a);



/*        String alg1 = "Insertion";
        String alg2 = "Selection";
        int N = Integer.parseInt("1000");//�Գ���Ϊ N���ɵ���������ָ����
        int T = Integer.parseInt("100");//�ظ� T �Σ��ɵ��ĸ�����ָ����
        double t1 = timeRandomInput(alg1, N, T); // �㷨1����ʱ��
        double t2 = timeRandomInput(alg2, N, T); // �㷨2����ʱ��
        StdOut.printf(" For %d random Doubles\n %s is" , N, alg1);
        StdOut.printf(" %.1f times faster than %s\n" , t2/t1, alg2);*/

    }

    public static double time(String alg, Comparable[] a)
    {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
/*        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);*/
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T)
    { // ʹ���㷨1��T������ΪN����������
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++)
        { // ����һ�β��ԣ�����һ�����鲢����)
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    //public static void sort(Comparable[] a) { /* ����㷨2.1�� �㷨2.2�� �㷨2.3�� �㷨2.4�� �㷨2.5���㷨2.7*/ }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }



    public static void show(Comparable[] a) { // �ڵ����д�ӡ����
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();

    }

    public static boolean isSorted(Comparable[] a) { // ��������Ԫ���Ƿ�����
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void printComprable(Comparable[] a){
        for(int x =0;x<a.length;x++){
            System.out.print(a[x]);

        }
        System.out.println(" ");
        System.out.println(" ");
    }

}
