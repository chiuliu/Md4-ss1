package ra.baitap01.repository;

import ra.baitap01.model.entity.Account;

import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();
    Account findById(Integer id);
    Boolean save(Account account);
    Boolean deleteById(Integer id);
}
