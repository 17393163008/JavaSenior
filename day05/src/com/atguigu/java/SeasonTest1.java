package com.atguigu.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * @author pqq
 * @create ${year}-06-14 9:04
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);

        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);

        }

        System.out.println("**************");
        Thread.State[] value1 = Thread.State.values();
        for (int i = 0; i < value1.length; i++) {
            System.out.println(value1[i]);

        }

        //valueOf（String objName）：返回枚举类中对象名是objName的对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }
}

interface Info{
    void show();
}

//使用enum关键字枚举类
enum  Season1 implements Info{
    //1、提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    WINTER("冬天", "寒冬凛冽"){
        @Override
        public void show() {
            System.out.println("冷雨夜");
        }
    };

    //2、私有化类的构造器,并给对象属性赋值
    private final String seasonName;
    private final String seasonDesc;


    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4、其他诉求，获取枚举类对象的属性
    public String getSeasonName(){
        return seasonName;
    }

    public String getSeasonDesc(){
        return seasonDesc;
    }



//    //4、其他诉求类：提供toString()
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}