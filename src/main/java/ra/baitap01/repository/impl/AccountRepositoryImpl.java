package ra.baitap01.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ra.baitap01.model.entity.Account;
import ra.baitap01.model.entity.Employee;
import ra.baitap01.repository.IAccountRepository;

import java.util.List;

@Repository
@Transactional
public class AccountRepositoryImpl implements IAccountRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Account> findAll() {
        return entityManager.createQuery("from Account", Account.class).getResultList();
    }

    @Override
    public Account findById(Integer id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public Boolean save(Account account) {
        if (account.getId() == null) {
            entityManager.persist(account);
        }
        else {
            entityManager.merge(account);
        }
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        entityManager.remove(findById(id));
        return true;
    }
}
