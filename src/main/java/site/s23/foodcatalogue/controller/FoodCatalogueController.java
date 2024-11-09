package site.s23.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.s23.foodcatalogue.dto.FoodCatalogueDetails;
import site.s23.foodcatalogue.dto.FoodItemDTO;
import site.s23.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping(path = "/foodcatalogue")
public class FoodCatalogueController {

	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	@PostMapping(path = "/add")
	public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
		
		FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO);
		
		return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/get/{restaurantId}")
	public ResponseEntity<FoodCatalogueDetails> getFoodCatalogueByRestaurant(@PathVariable int restaurantId) {
		
		FoodCatalogueDetails foodCatalogueDetails = foodCatalogueService.getFoodCatalogueByRestaurant(restaurantId);
		return new ResponseEntity<>(foodCatalogueDetails, HttpStatus.OK);
	}
	
	@GetMapping("/getItem/{itemId}")
	public ResponseEntity<FoodItemDTO> getFoodItemDetails(@PathVariable int itemId) {
		
		FoodItemDTO itemDetails = foodCatalogueService.getFoodItemDetailsById(itemId);
		return new ResponseEntity<>(itemDetails, HttpStatus.OK);
	}
	
}
