package com.library.rest.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.rest.service.dto.BookDTO;
import com.library.rest.service.dto.WishListDTO;

@Service
public class ItemWishListServiceImpl implements ItemWishListService {

	@Override
	public List<BookDTO> saveWishList(WishListDTO wishListDTO) {
		return null;
	}

}
