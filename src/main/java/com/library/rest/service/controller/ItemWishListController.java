package com.library.rest.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.rest.service.service.ItemWishListService;

@RestController
@RequestMapping("/wishlist")
public class ItemWishListController {

	private ItemWishListService itemWishListService;

	public ItemWishListController(ItemWishListService itemWishListService) {
		this.itemWishListService = itemWishListService;
	}
	
	

}
