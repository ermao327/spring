package day2.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect//表示是一个切面
public class LogAdvice {
    //定义切点表达式,可定义多个(重要知识点)
	@Pointcut("execution(* day2.demo1.impl.*.*(..))")
	public void pc1(){}
		
	@Pointcut("execution(*  day2.demo1.impl.*Impl.*(..))")
	public void pc2(){}

	//前置通知:返回类型任意，任意包下的impl子包中以Impl结尾的类中，任意方法中任意参数
	//@Before("execution(* *.impl.*Impl.*(..))")
	@Before("pc1()")//也可写作@Before("LogAdvice.pc1()")
	public void log1(JoinPoint jp){
		Signature sg = jp.getSignature();
		MethodSignature ms = (MethodSignature) sg;
		String name = ms.getName();
		Method m = ms.getMethod();//切入点，也就是方法
		Object[]args=jp.getArgs();//方法参数
		
		Object target = jp.getTarget();
		System.out.println("LogAdvice.log,方法名："+name+",参数："+ Arrays.toString(args)+",target:"+target);
	}
	
	//注意返回值rv必须跟方法的形参保持一致
	@AfterReturning(value="pc2()",returning="rv")//后置通知
	public void log2(JoinPoint jp,Object rv){
		System.out.println("log2中，方法返回值："+rv);
	}
	
	//注意：这里的"e"必须跟形参e名字保持一致
	@AfterThrowing(value="pc2()",throwing="e")
	void log3(JoinPoint jp,Exception e){
		System.out.println("log3监测到异常,e="+e);
	}

	@Around("pc1()")//环绕通知
	Object around(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("开启事务");
		Object o=null;
		try{
			o=jp.proceed();
			System.out.println("提交事务");
		}catch(Throwable e){
			System.out.println("回滚事务");
			throw e;
		}
		return o;
	}
	
	//最终通知
	@After("pc1()")
	void finallyMethod(){
		System.out.println("相当于finally语句块，死活都要执行");
	}
}