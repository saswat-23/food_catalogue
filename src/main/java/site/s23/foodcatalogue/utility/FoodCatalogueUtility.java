package site.s23.foodcatalogue.utility;

import site.s23.foodcatalogue.dto.FoodItemDTO;
import site.s23.foodcatalogue.model.FoodItem;

public class FoodCatalogueUtility {

	
		public static FoodItem getFoodItemEntityFromFoodItemDTO(final FoodItemDTO foodItemDTO, FoodItem foodItemEntity) {
			foodItemEntity = new FoodItem(foodItemDTO.getId(), foodItemDTO.getItemName(), foodItemDTO.getItemDescription(),
					foodItemDTO.isVeg(), foodItemDTO.getPrice(), foodItemDTO.getRestaurantId(), foodItemDTO.getQuantity());
			
			return foodItemEntity; 
		}
	
		public static FoodItemDTO getFoodItemDTOFromFoodItemEntity(final FoodItem foodItem, FoodItemDTO foodItemDTO) {
			foodItemDTO = new FoodItemDTO(foodItem.getId(), foodItem.getItemName(), foodItem.getItemDescription(),
					foodItem.isVeg(), foodItem.getPrice(), foodItem.getRestaurantId(), foodItem.getQuantity());
			
			return foodItemDTO; 
		}
		
}
