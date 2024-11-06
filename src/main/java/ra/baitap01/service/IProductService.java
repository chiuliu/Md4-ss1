package ra.baitap01.service;

import ra.baitap01.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
    Boolean save(Product product);
    Boolean deleteById(Integer id);
}
