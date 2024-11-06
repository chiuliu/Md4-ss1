package ra.baitap01.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ra.baitap01.model.entity.Employee;
import ra.baitap01.repository.IEmployeeRepository;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements IEmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            entityManager.persist(employee);
        }
        else {
            entityManager.merge(employee);
        }
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(findById(id));
    }

    @Override
    public List<Employee> search(String keyword) {
        return  entityManager.createQuery("from Employee where fullName like :keyword or departmentName like :keyword",Employee.class).setParameter("keyword", "%" + keyword + "%").getResultList();
    }
}
