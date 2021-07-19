package com.atguigu.java3;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针而创建的。
 *
 * 常用的方法：ofNullable(T t)
 *            ofElse(T t)
 *
 * @author pqq
 * @create ${year}-06-21 16:54
 */
public class OptionalTest {
    //Optional.of(T t):创建一个Optional实例，t必须非空
    //Optional.empty():创建一个空的Optional实例
    //Optional.ofNullable(T t):t可以为null
    @Test
    public void test1(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);
    }

    public String getGrilName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test2(){
        Boy boy = new Boy();
        String grilName = getGrilName(boy);
        System.out.println(grilName);
    }

    //优化以后的getGirlName():
    public String getGrilName1(Boy boy){
        if(boy!=null){
            Girl girl = boy.getGirl();
            if(girl!=null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        String grilName = getGrilName1(boy);
        System.out.println(grilName);
    }

    @Test
    public void test4(){
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        //orElse(T t):t可以为null
        //如果内部的t是空的，则返回orElse()方法中的参数t1
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
    }

    //使用Optional类的getGirlName():
    public String getGrilName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);

        //此时的boy1一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();

        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));


        return girl1.getName();
    }

    @Test
    public void test5(){
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("苍老师"));
        String grilName2 = getGrilName2(boy);
        System.out.println(grilName2);
    }

}
