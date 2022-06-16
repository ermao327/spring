package day2.demo1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    ClassPathXmlApplicationContext a;

    @Before
    public void before() {
        a = new ClassPathXmlApplicationContext("day2/demo1.xml");
    }

    @Test
    public void test() {
        a.getBean(UserService.class).login("张三", "123");
    }
}
