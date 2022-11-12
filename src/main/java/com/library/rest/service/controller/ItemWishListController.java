package com.library.rest.service.controller;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/item/wishItems")
public class ItemWishListController {

	private ItemWishListService itemWishListService;

	public ItemWishListController(final ItemWishListService itemWishListService) {
		this.itemWishListService = itemWishListService;
	}

	@GetMapping(value = "/all")
	public ResponseDTO getAllUsersWishList() {
		Map<String, List<BookDTO>> userWishList = itemWishListService.getAllUsersWishList();
		return new ResponseDTO("Success", userWishList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/save", consumes = "application/json")
	public ResponseDTO saveWishList(@RequestBody final WishListDTO wishListDTO) {
		List<BookDTO> userWishList = itemWishListService.updateWishList(wishListDTO);
		return new ResponseDTO("Success", userWishList, HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}")
	public ResponseDTO getWishListByUserId(@PathVariable("userId") final String userId) {
		List<BookDTO> userWishList = itemWishListService.getWishListByUserId(userId);
		return new ResponseDTO("Success", userWishList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/remove", consumes = "application/json")
	public ResponseDTO removeWishList(@RequestBody final WishListDTO wishListDTO) {
		List<BookDTO> userWishList = itemWishListService.removeWishList(wishListDTO);
		return new ResponseDTO("Success", userWishList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/update", consumes = "application/json")
	public ResponseDTO updateWishList(@RequestBody final WishListDTO wishListDTO) {
		List<BookDTO> userWishList = itemWishListService.updateWishList(wishListDTO);
		return new ResponseDTO("Success", userWishList, HttpStatus.OK);
	}

}
