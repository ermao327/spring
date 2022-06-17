package day3;

import day3.service.A;
import day3.service.AccountServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    AccountServiceImpl as;
    ApplicationContext ac;
    @Before
    public void init(){
        ac=new ClassPathXmlApplicationContext("day3/spring.xml");
        as = ac.getBean(AccountServiceImpl.class);
    }
    @After
    public void over(){
        as.query("a1");
        as.query("a2");
    }
    
 	@Test
    public void t(){
        try{
            as.transfer("a1","a2",100.0);
        }catch (Exception e){
            System.out.println("=========="+e.getMessage()+"===========");
        }
    }


    @Test
    public void propagation(){
        A a =  ac.getBean(A.class);
        try{
            a.a("a1","a2",100.0);
        }catch (Exception e){
            System.out.println("=========="+e.getMessage()+"===========");
        }
    }


}