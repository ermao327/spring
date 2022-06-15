package day1.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext a = new ClassPathXmlApplicationContext("day1/demo1.xml");
        System.out.println(a.getBean("s1"));
    }
}
