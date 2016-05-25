package com.hzy.test;

/**
 * Created by Hzy on 2016/5/13.
 */
//�㷨 3.1 ˳����ң� ������������
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
    private Node first; // �����׽��

    private class Node { // ������Ķ���
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) { // ���Ҹ����ļ��� �����������ֵ
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val; // ����
        return null; // δ����
    }

    public void put(Key key, Value val) { // ���Ҹ����ļ��� �ҵ��������ֵ�� �����ڱ����½����
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.val = val;
                return;
            } // ���У� ����
        first = new Node(key, val, first); // δ���У� �½����
    }
}

