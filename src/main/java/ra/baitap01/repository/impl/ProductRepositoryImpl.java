package ra.baitap01.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ra.baitap01.model.entity.Product;
import ra.baitap01.repository.IProductRepository;

import java.util.List;


@Repository
@Transactional
public class ProductRepositoryImpl implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Boolean save(Product product) {

        if (product.getId() == null) {
            entityManager.persist(product);
        }
        else {
            entityManager.merge(product);
        }
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        entityManager.remove(findById(id));
        return true;
    }
}
