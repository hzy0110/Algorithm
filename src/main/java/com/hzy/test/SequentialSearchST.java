package com.hzy.test;

/**
 * Created by Hzy on 2016/5/13.
 */
//算法 3.1 顺序查找（ 基于无序链表）
/******************************************************************************
 *  Compilation:  javac SequentialSearchST.java
 *  Execution:    java SequentialSearchST
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/31elementary/tinyST.txt
 *
 *  Symbol table implementation with sequential search in an
 *  unordered linked list of key-value pairs.
 *
 *  % more tinyST.txt
 *  S E A R C H E X A M P L E
 *
 *  % java SequentialSearchST < tiny.txt
 *  L 11
 *  P 10
 *  M 9
 *  X 7
 *  H 5
 *  C 4
 *  R 3
 *  A 8
 *  E 12
 *  S 0
 *
 ******************************************************************************/


public class SequentialSearchST<Key, Value> {
    private Node first; // 链表首结点

    private class Node { // 链表结点的定义
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) { // 查找给定的键， 返回相关联的值
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val; // 命中
        return null; // 未名中
    }

    public void put(Key key, Value val) { // 查找给定的键， 找到则更新其值， 否则在表中新建结点
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.val = val;
                return;
            } // 命中， 更新
        first = new Node(key, val, first); // 未命中， 新建结点
    }
}

