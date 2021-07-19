package com.atguigu.exer;

        import org.junit.Test;

        import java.util.ArrayList;
        import java.util.List;


/**
 * @author pqq
 * @create ${year}-06-15 9:24
 */
public class ListExer {
    @Test
    public void testListRomove(){
        /*
        区分List中remove(int index)和remove(Object obj)
         */

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        uodateList(list);
        System.out.println(list);

    }

    private void uodateList(List list){
        //list.remove(2);
        list.remove(new Integer(2));
    }
}
