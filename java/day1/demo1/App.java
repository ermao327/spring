package day1.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext a = new ClassPathXmlApplicationContext("u.xml");
        System.out.println(a.getBean("s"));
    }
}
