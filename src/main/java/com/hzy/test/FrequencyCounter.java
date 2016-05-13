package com.hzy.test;

import com.hzy.util.ST;
import com.hzy.util.StdIn;
import com.hzy.util.StdOut;

/**
 * Created by Hzy on 2016/5/13.
 */
//3.1.3.2
public class FrequencyCounter {
    public static void main(String[] args)
    {
        int minlen = Integer.parseInt(args[0]); // ��С����
        ST<String, Integer> st = new ST<String, Integer>();
        while (!StdIn.isEmpty())
        { // ������ű�ͳ��Ƶ��
            String word = StdIn.readString();
            if (word.length() < minlen) continue; // ���Խ϶̵ĵ���
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }
        // �ҳ�����Ƶ����ߵĵ���
        String max = " ";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        StdOut.println(max + " " + st.get(max));
    }
}
