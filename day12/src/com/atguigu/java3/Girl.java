package com.atguigu.java3;

/**
 * @author pqq
 * @create ${year}-06-21 16:52
 */
public class Girl {
    private String name;

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }
}
