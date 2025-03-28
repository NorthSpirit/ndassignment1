package lt.viko.eif.mjurevicius.ndassignment1.db;

import lt.viko.eif.mjurevicius.ndassignment1.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
