package site.s23.foodcatalogue.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.s23.foodcatalogue.model.FoodItem;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalogueDetails {
	
	public List<FoodItem> foodItemList;
	
	public RestaurantDTO restaurant;
	
}
