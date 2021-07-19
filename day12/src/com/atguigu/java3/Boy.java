package com.atguigu.java3;

/**
 * @author pqq
 * @create ${year}-06-21 16:52
 */
public class Boy {
    private Girl girl;

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Boy() {
    }
}
