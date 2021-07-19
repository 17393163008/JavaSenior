package com.atguigu.java;

/**
 * 静态代理类
 *
 * 特点：代理类和被代理类在编译期间就确定下来了。
 *
 * @author pqq
 * @create ${year}-06-20 16:30
 */
interface ClothFactory{
    void produceCloth();
}

public class StaticProxyTest {

    public static void main(String[] args) {
        //创建被代理对象
        NikeClothFactory nike = new NikeClothFactory();

        //创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}


class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory; //用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的首位工作");
    }
}


//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

