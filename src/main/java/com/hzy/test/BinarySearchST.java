package com.hzy.test;

/**
 * Created by Hzy on 2016/5/17.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) { // ���������С�ı�׼��������㷨1.1
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }


    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (N==0) return null;
        int i = rank(key,0,N-1);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public int rank(Key key, int lo, int hi){
        if (hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0)
            return rank(key, lo, mid-1);
        else if (cmp > 0)
            return rank(key, mid+1, hi);
        else return mid;
    }

    // ����㷨3.2����1��
    public void put(Key key, Value val) { // ���Ҽ��� �ҵ������ֵ�� ���򴴽��µ�Ԫ��
        int i = rank(key,0,N-1);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

  //  public void delete(Key key)
// �÷�����ʵ�������ϰ3.1.16

}
