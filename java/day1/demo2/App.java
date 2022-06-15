package day1.demo2;

import day1.demo2.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext a = new ClassPathXmlApplicationContext("day1/demo2.xml");
        System.out.println(a.getBean("u1"));
//        a.getBean(User.class);
    }
}
