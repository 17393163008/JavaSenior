package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 * @author pqq
 * @create ${year}-06-20 16:41
 */
interface Human{
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}

class HumanUTil1{
    public void method1(){
        System.out.println("==============通用方法1=============");

    }

    public void method2(){

        System.out.println("==============通用方法2=============");
    }
}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
问题二：当通过代理类的对象调用方法时，如何动态的去调用代理类中的同名方法
 */

class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){  //obj:被代理的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;  //赋值时，需要使用被代理的对象进行赋值
    //当我通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能声明在invoke()中

    public void bind(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUTil1 uTil1 = new HumanUTil1();
        uTil1.method1();

        //method:即为代理类对象调用的方法，此方法也就作为了被代理对象要调用的方法
        //obj：被代理的对象
        Object returnValue = method.invoke(obj, args);

        uTil1.method2();

        //上述方法的返回值就作为当前类中的invoke()
        return returnValue;

    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();

        //这里类型不能写成SuperMan，不然SuperMan既是代理类，又是非代理类
        //proxyInstance：代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("****************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.produceCloth();

    }

}
