package ra.baitap01.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap01.model.entity.Account;
import ra.baitap01.repository.IAccountRepository;
import ra.baitap01.service.IAccountService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Boolean save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return accountRepository.deleteById(id);
    }
}
