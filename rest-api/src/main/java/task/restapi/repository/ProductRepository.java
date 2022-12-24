package task.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.restapi.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByIdAsc();

    boolean existsBySlug(String slug);
}