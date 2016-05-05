package com.hzy.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zy on 2016/5/3.
 */
public class ChapterOne {

    private static final Logger logger = LoggerFactory.getLogger(ChapterOne.class);
    public static void main(String args[]){
        Double d = 2.0e-6 * 100000000.1;
        logger.info(d.toString());
    }
}
