package com.hzy.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zy on 2016/5/3.
 */
public class ChapterOne {

    private static final Logger logger = LoggerFactory.getLogger(ChapterOne.class);
    public static void main(String args[]) {
        //1.1.1
   /*     Double d = 2.0e-6 * 100000000.1;
        logger.info(d.toString());*/

        //1.1.6
/*        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            logger.info(Integer.toString(f));
            f = f + g;
            g = f - g;
        }*/

        //1.1.9
/*
//        int x = 3;
//        int x1 = x/2;
//        logger.info(Integer.toString(x1));
//        x/=2;
//        logger.info(Integer.toString(x));
        String s = "";
        int N = 9;
        for(int n=N;n>0;n/=2){
            logger.info(Integer.toString(n));
            s += (n%2);
        }
        logger.info(s);*/

        //1.1.13
       /* int[][] ints1 = {{1, 2, 3}, {4, 5, 6}};

        int[][] ints2 = new int[ints1[0].length][ints1.length];
        for (int j = 0; j < ints1[0].length; j++) {
            for (int i = 0; i < ints1.length; i++) {

//                logger.info("j=" + j);
//                logger.info("i=" + i);
//                logger.info(Integer.toString(ints1[i][j]));
                ints2[j][i] = ints1[i][j];

            }
        }

        for (int i = 0; i < ints2.length; i++) {
            for (int j = 0; j < ints2[i].length; j++) {
                logger.info(Integer.toString(ints2[i][j]));

            }
        }
*/

        //logger.info(Integer.toString(lg(1)));

    }


    //1.1.14
    public static int lg(int n){
        return (int)Math.log(81);//4
        
    }

    //1.1.16
    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    //1.1.17
    public static String exR2(int n)
    {
        String s = exR2(n-3) + n + exR2(n-2) + n;
        if (n <= 0) return "";
        return s;
    }
}
