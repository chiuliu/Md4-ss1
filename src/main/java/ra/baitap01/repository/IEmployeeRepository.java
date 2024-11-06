package ra.baitap01.repository;

import ra.baitap01.model.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();
    Employee findById(Integer id);
    void save(Employee employee);
    void deleteById(Integer id);
    List<Employee> search(String keyword);
}

