package lt.viko.eif.mjurevicius.ndassignment1.db;

import lt.viko.eif.mjurevicius.ndassignment1.model.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long> {
}
