package ra.baitap01.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.baitap01.model.entity.Product;
import ra.baitap01.repository.IProductRepository;
import ra.baitap01.service.IProductService;

import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return productRepository.deleteById(id);
    }
}
