package day1.demo4;

import day1.demo2.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    ClassPathXmlApplicationContext a;

    @Before
    public void before() {
        a = new ClassPathXmlApplicationContext("day1/demo4.xml");
    }

    @Test
    public void test() {
        System.out.println(a.getBean("person"));
//        System.out.println(a.getBean(UserServiceImpl.class).name);
        a.getBean(Person.class).setName("zhangsa123123n");
        System.out.println(a.getBean(Person.class).name);
        System.out.println(a.getBean(Person.class).age);
        System.out.println("----------------------------------------------------");


    }


}
