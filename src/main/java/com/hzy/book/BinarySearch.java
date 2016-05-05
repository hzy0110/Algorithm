package com.hzy.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by zy on 2016/5/3.
 */
public class BinarySearch {
    private static final Logger logger = LoggerFactory.getLogger(BinarySearch.class);
    public static int rank(int key,int[] a){
        int lo =0;
        int hi = a.length -1;
        while (lo<= hi){
            int mid = lo + (hi - lo)/2;
            if(key<a[mid]){
                hi = mid-1;
            }
            else if(key > a[mid]){
                lo = mid +1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int[] whilelist = {20, 5, 2, 7, 234, 123, 4, 567, 345, 23};
        Arrays.sort(whilelist);
        int key = 7;
        int r = rank(key, whilelist);
        logger.info("return=:"+Integer.toString(whilelist[r]));
    }
}
