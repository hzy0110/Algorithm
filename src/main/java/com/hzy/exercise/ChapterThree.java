package com.hzy.exercise;

import com.hzy.util.ST;
import com.hzy.util.StdIn;
import com.hzy.util.StdOut;

/**
 * Created by Hzy on 2016/5/13.
 */
public class ChapterThree {
    public static void main(String[] args)
    {
        ST<String, Integer> st;
        st = new ST<String, Integer>();
        for (int i = 0; i  < args.length; i++)
        {
            String key = args[i];
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
/*    S
            E
    A
            R
    C
            H
    E
            X
    A
            M
    P
            L
    E*/
}
