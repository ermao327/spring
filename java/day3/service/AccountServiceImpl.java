package day3.service;

import day3.dao.AccountDao;
import day3.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl {
	@Autowired
	AccountDao dao;
	@Transactional(propagation = Propagation.SUPPORTS )//默认runtimeException时会回滚
	public void transfer(String from, String to, Double money) {
		dao.update(from, 0-money);
//		System.out.println("first---测试虚读"+dao.selectAllAccount());
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {}
//		System.out.println("last---测试虚读"+dao.update("a3",100.0));
		int a = 1/0;
		dao.update(to, money);
	}

	
	public void query(String name) {
		System.out.println(name+"的余额："+dao.selectMoney(name));
	}

	
	public void insert() {
		System.out.println(dao.insert(new Account(null,"a3",500.0)));
	}
}