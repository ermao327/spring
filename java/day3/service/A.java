package day3.service;

import day3.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class A {
    @Autowired
    AccountServiceImpl service;
    @Transactional
    public void a(String from, String to, Double money){
        service.transfer(from,to,money);
    }
}