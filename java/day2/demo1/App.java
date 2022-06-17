package day2.demo1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {

    ClassPathXmlApplicationContext a;

    @Before
    public void before() {
        a = new ClassPathXmlApplicationContext("day2/demo1.xml");
    }

    @Test
    public void test() {
        a.getBean(UserService.class).login("张三", "123");

        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                (ThreadFactory) new ThreadPoolExecutor.AbortPolicy(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                a.getBean(UserService.class).login("张三", "123");
            }
        });

    }
}
