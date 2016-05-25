package com.hzy.util;

/******************************************************************************
 *  Compilation:  javac Graph.java
 *  Execution:    java Graph input.txt
 *  Dependencies: Bag.java In.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/41graph/tinyG.txt
 *
 *  A graph, implemented using an array of sets.
 *  Parallel edges and self-loops allowed.
 *
 *  % java Graph tinyG.txt
 *  13 vertices, 13 edges
 *  0: 6 2 1 5
 *  1: 0
 *  2: 0
 *  3: 5 4
 *  4: 5 6 3
 *  5: 3 4 0
 *  6: 0 4
 *  7: 8
 *  8: 7
 *  9: 11 10 12
 *  10: 9
 *  11: 9 12
 *  12: 11 9
 *
 *  % java Graph mediumG.txt
 *  250 vertices, 1273 edges
 *  0: 225 222 211 209 204 202 191 176 163 160 149 114 97 80 68 59 58 49 44 24 15
 *  1: 220 203 200 194 189 164 150 130 107 72
 *  2: 141 110 108 86 79 51 42 18 14
 *  ...
 *
 ******************************************************************************/

/**
 *  The <tt>Graph</tt> class represents an undirected graph of vertices
 *  named 0 through <em>V</em> - 1.
 *  It supports the following two primary operations: add an edge to the graph,
 *  iterate over all of the vertices adjacent to a vertex. It also provides
 *  methods for returning the number of vertices <em>V</em> and the number
 *  of edges <em>E</em>. Parallel edges and self-loops are permitted.
 *  <p>
 *  This implementation uses an adjacency-lists representation, which
 *  is a vertex-indexed array of {@link Bag} objects.
 *  All operations take constant time (in the worst case) except
 *  iterating over the vertices adjacent to a given vertex, which takes
 *  time proportional to the number of such vertices.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/41graph">Section 4.1</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Graph {
    private final int V; // ������Ŀ
    private int E; // �ߵ���Ŀ
    private Bag<Integer>[] adj; // �ڽӱ�
    public Graph(int V)
    {
        this.V = V; this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; // �����ڽӱ�
        for (int v = 0; v < V; v++) // �����������ʼ��Ϊ��
            adj[v] = new Bag<Integer>();
    }

    public Graph(In in)
    {
        this(in.readInt()); // ��ȡV����ͼ��ʼ��
        int E = in.readInt(); // ��ȡE
        for (int i = 0; i < E; i++)
        { // ���һ����
            int v = in.readInt(); // ��ȡһ������
            int w = in.readInt(); // ��ȡ��һ������
            addEdge(v, w); // ���һ���������ǵı�
        }
    }

    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w)
    {
        adj[v].add(w); // ��w��ӵ�v��������
        adj[w].add(v); // ��v��ӵ�W��������
        E++;
    }
    public Iterable<Integer> adj(int v)
    { return adj[v]; }
}
