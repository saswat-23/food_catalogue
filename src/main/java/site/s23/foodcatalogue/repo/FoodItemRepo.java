package site.s23.foodcatalogue.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.s23.foodcatalogue.model.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer>{

	List<FoodItem> findByRestaurantId(int restaurantId);

}
