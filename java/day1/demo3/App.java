package day1.demo3;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    ClassPathXmlApplicationContext a;
    @Before
    public void init(){
        a = new ClassPathXmlApplicationContext("day1/demo3.xml");
    }
    @Test
    public void m1(){
        System.out.println(a.getBean("e2"));
    }
}
