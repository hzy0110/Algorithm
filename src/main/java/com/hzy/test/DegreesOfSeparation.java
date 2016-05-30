package com.hzy.test;

import com.hzy.util.Graph;
import com.hzy.util.In;
import com.hzy.util.StdIn;
import com.hzy.util.StdOut;

/**
 * Created by Hzy on 2016/5/30.
 */
public class DegreesOfSeparation {
    public static void main(String[] args)
    {
        SymbolGraph sg = new SymbolGraph("e:\\movies.txt", "/");
        In in =  new In("e:\\movies.txt");

        Graph G = sg.G();
        String source = "Animal House (1978)";
        if (!sg.contains(source))
        { StdOut.println(source + "not in database."); return; }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        //while (!StdIn.isEmpty())
        //{
            String sink = in.readLine();
            if (sg.contains(sink))
            {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t))
                    for (int v : bfs.pathTo(t))
                        StdOut.println(" " + sg.name(v));
                else StdOut.println("Not connected");
            }
            else StdOut.println("Not in database.");
        //}
    }
}
