package site.s23.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodItemDTO {

	private int id;
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private long price;
	private int restaurantId;
	private int quantity;
	
}
