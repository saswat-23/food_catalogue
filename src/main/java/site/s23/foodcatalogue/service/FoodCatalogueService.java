package site.s23.foodcatalogue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import site.s23.foodcatalogue.dto.FoodCatalogueDetails;
import site.s23.foodcatalogue.dto.FoodItemDTO;
import site.s23.foodcatalogue.dto.RestaurantDTO;
import site.s23.foodcatalogue.model.FoodItem;
import site.s23.foodcatalogue.repo.FoodItemRepo;
import site.s23.foodcatalogue.utility.FoodCatalogueUtility;

@Service
public class FoodCatalogueService {

	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	RestTemplate restTemplate;

	public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {

		FoodItem foodItem = foodItemRepo.save(FoodCatalogueUtility.getFoodItemEntityFromFoodItemDTO(foodItemDTO, new FoodItem()));
		return FoodCatalogueUtility.getFoodItemDTOFromFoodItemEntity(foodItem, new FoodItemDTO());
	}

	public FoodCatalogueDetails getFoodCatalogueByRestaurant(int restaurantId) {

		//Fetch the details of the restaurant (from Restaurant microservice)
		RestaurantDTO restaurant = getRestaurantInfoById(restaurantId);
		
		// Fetch the the details of the items that the restaurant has listed.
		List<FoodItem> foodItems = getFoodItemByRestaurantId(restaurantId);
		
		return new FoodCatalogueDetails(foodItems, restaurant);
	}
	
	
	protected RestaurantDTO getRestaurantInfoById(int restaurantId) {
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, RestaurantDTO.class);
	}
	
	protected List<FoodItem> getFoodItemByRestaurantId(int restaurantId) {
		return foodItemRepo.findByRestaurantId(restaurantId);
	}

	public FoodItemDTO getFoodItemDetailsById(int itemId) {
		
		Optional<FoodItem> foodItem = foodItemRepo.findById(itemId);
		return FoodCatalogueUtility.getFoodItemDTOFromFoodItemEntity(foodItem.get(), new FoodItemDTO());
	}
	
	
}
