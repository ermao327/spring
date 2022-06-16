package day2.demo1.impl;

import day2.demo1.UserService;
import org.springframework.stereotype.Service;

@Service("service")
public class UserServiceImpl implements UserService {
    @Override
	public String login(String name, String pass) {
		System.out.println("login登录...");
		//int a=5/0;
		try {
			
			Thread.sleep(500);
		} catch (Exception e) {}
		return "登录成功";
	}
	
	@Override
	public void logout() {
		System.out.println("拜拜");
	}
}