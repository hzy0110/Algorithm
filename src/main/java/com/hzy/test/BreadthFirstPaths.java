package com.hzy.test;

import com.hzy.util.*;

/**
 * Created by Hzy on 2016/5/27.
 */
public class BreadthFirstPaths {
    private boolean[] marked; // 到达该顶点的最短路径已知吗？
    private int[] edgeTo; // 到达该顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true; // 标记起点
        queue.enqueue(s); // 将它加入队列
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // 从队列中删去下一顶点
            for (int w : G.adj(v))
                if (!marked[w]) // 对于每个未被标记的相邻顶点
                {
                    edgeTo[w] = v; // 保存最短路径的最后一条边
                    marked[w] = true; // 标记它， 因为最短路径已知
                    queue.enqueue(w); // 并将它添加到队列中
                }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
        // 和深度优先搜索中的实现相同（请见算法4.1）
    }

    public static void main(String[] args)
    {
        Graph G = new Graph(new In("e:\\tinyCG.txt"));
        int s = Integer.parseInt("0");
        BreadthFirstPaths bfp = new BreadthFirstPaths(G,s);
        for (int v = 0; v < G.V(); v++)
        {
            StdOut.print(s + " to " + v + ": ");

            if (bfp.hasPathTo(v))
                for (int x : bfp.pathTo(v))
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            StdOut.println();
        }
    }

}
