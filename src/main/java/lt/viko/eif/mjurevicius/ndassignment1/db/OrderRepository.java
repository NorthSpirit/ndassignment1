package lt.viko.eif.mjurevicius.ndassignment1.db;

import lt.viko.eif.mjurevicius.ndassignment1.model.Foodorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Foodorder, Long> {
}
