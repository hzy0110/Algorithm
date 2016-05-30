package com.hzy.test;

import com.hzy.util.*;

/**
 * Created by Hzy on 2016/5/30.
 */
public class SymbolGraph {

    private ST<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Graph G;

    public SymbolGraph(String filename, String delimiter) {
        st = new ST<String, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        In in = new In(filename);
        // while (in.hasNextLine()) {
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(delimiter);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        StdOut.println("Done reading " + filename);

        // inverted index to get string keys in an aray
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        // second pass builds the graph by connecting first vertex on each
        // line to all others
        G = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                G.addEdge(v, w);
            }
        }
    }

    public Graph G() {
        return G;
    }

    public String name(int v) {
        return keys[v];
    }

    public int index(String s) {
        return st.get(s);
    }

    public boolean contains(String s) {
        return st.contains(s);
    }


    public static void main(String[] args)
    {
        String filename  = "e:\\routes.txt";
        String delimiter = " ";
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();
        //while (StdIn.hasNextLine())
        //{
            //String source = StdIn.readLine();
            for (int w : G.adj(sg.index("JFK")))
                StdOut.println(" " + sg.name(w));
        //}
    }
}
