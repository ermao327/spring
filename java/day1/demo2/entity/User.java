package day1.demo2.entity;

public class User {
	String name="abc";
//封装和toString
	{
		System.out.println("User初始块。。。");
	}

	public User() {
		System.out.println("构造方法");
	}

	//设置一个初始化方法,方法名任意
	public void toUpperCase() {
		System.out.println("toUper");
		name= name.toUpperCase();
	}

	//设置一个销毁方法，当该对象被容器销毁时调用,方法名任意
	public void gameOver(){
		System.out.println("gameOver()被调用...");
	}
}