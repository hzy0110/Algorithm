package com.hzy.test;

import com.hzy.util.*;

/**
 * Created by Hzy on 2016/5/27.
 */
public class BreadthFirstPaths {
    private boolean[] marked; // ����ö�������·����֪��
    private int[] edgeTo; // ����ö������֪·���ϵ����һ������
    private final int s; // ���

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true; // ������
        queue.enqueue(s); // �����������
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // �Ӷ�����ɾȥ��һ����
            for (int w : G.adj(v))
                if (!marked[w]) // ����ÿ��δ����ǵ����ڶ���
                {
                    edgeTo[w] = v; // �������·�������һ����
                    marked[w] = true; // ������� ��Ϊ���·����֪
                    queue.enqueue(w); // ��������ӵ�������
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
        // ��������������е�ʵ����ͬ������㷨4.1��
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
