package com.library.rest.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.rest.service.dto.BookDTO;
import com.library.rest.service.dto.ResponseDTO;
import com.library.rest.service.dto.WishListDTO;
import com.library.rest.service.service.ItemWishListService;

@RestController
@RequestMapping("/item")
public class ItemWishListController {

	private ItemWishListService itemWishListService;

	public ItemWishListController(final ItemWishListService itemWishListService) {
		this.itemWishListService = itemWishListService;
	}

	@PostMapping(value = "/wishItems/save", consumes = "application/json")
	public ResponseDTO saveWishList(@RequestBody final WishListDTO wishListDTO) {
		itemWishListService.saveWishList(wishListDTO);
		return new ResponseDTO("Success", "Wish List Save Successfully", HttpStatus.OK);
	}

	@GetMapping(value = "/wishItems/{userId}", consumes = "application/json")
	public ResponseDTO getWishListByUserId(@PathVariable final String userId) {
		List<BookDTO> userWishList = itemWishListService.getWishListByUserId(userId);
		return new ResponseDTO("Success", userWishList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/wishItems/remove", consumes = "application/json")
	public ResponseDTO removeWishList(@RequestBody final WishListDTO wishListDTO) {
		itemWishListService.removeWishList(wishListDTO);
		return new ResponseDTO("Success", "Wish List Save Successfully", HttpStatus.OK);
	}

}
