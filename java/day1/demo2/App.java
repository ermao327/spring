package day1.demo2;

import day1.demo2.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws Exception {
        ApplicationContext a = new ClassPathXmlApplicationContext("day1/demo2.xml");
//        System.out.println(a.getBean("u1"));
        a.getBean(User.class);

        //    容器销毁
        ClassPathXmlApplicationContext cc = (ClassPathXmlApplicationContext) a;//强转
        cc.close();
        //也是执行销毁方法，跟上面区别：只有当本线程结束后才能执行销毁方法,上面是立刻执行销毁方法
//        cc.registerShutdownHook();
        Thread.sleep(5000);

    }

    ClassPathXmlApplicationContext a;

    @Before
    public void before() {
        a = new ClassPathXmlApplicationContext("day1/demo2.xml");
    }
    @Test
    public void test() {
        System.out.println(a.getBean("u1")==a.getBean("u1"));
    }
}
