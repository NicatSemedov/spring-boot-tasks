package task.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.restapi.entity.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByOrderByIdAsc();
}

