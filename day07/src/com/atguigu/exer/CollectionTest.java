package com.atguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author pqq
 * @create ${year}-06-15 21:07
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(12);
        coll.add(1);
        coll.add(1423);


        coll.forEach(System.out::println);
    }
}
