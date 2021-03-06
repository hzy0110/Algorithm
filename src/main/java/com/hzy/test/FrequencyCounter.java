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
        int minlen = Integer.parseInt(args[0]); // 最小键长
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        while (!StdIn.isEmpty())
        { // 构造符号表并统计频率
            String word = StdIn.readString();
            if (word.length() < minlen) continue; // 忽略较短的单词
            if (st.get(word)!=null) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

      /*  for (int i =0;i<args.length;i++)
        { // 构造符号表并统计频率
            String word = args[i];
            if (word.length() < minlen) continue; // 忽略较短的单词
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }*/
        // 找出出现频率最高的单词
        String max = " ";
        st.put(max, 0);
        //for (String word : st)
          //  if (st.get(word) > st.get(max))
            //    max = word;
        StdOut.println(max + " " + st.get(max));
    }
}
