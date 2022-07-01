package spring_security_lab6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_security_lab6.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAllByPriceGreaterThan(Double minPrice);
    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);
    List<Product> findAllByNameContains(String name);
}
