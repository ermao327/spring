package day3.dao;

import day3.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {
    Integer update(@Param("from") String from, @Param("money") Double money);
    Double selectMoney(String name);
    Integer insert(Account a);
    List<Account> selectAllAccount();
}