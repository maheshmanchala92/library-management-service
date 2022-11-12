package com.library.rest.service.service;

import java.util.List;

import com.library.rest.service.dto.BookDTO;
import com.library.rest.service.dto.WishListDTO;

public interface ItemWishListService {

	public List<BookDTO> saveWishList(WishListDTO wishListDTO);

}
