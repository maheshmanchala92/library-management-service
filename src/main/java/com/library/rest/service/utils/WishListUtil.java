package com.library.rest.service.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.rest.service.dto.BookDTO;

public class WishListUtil {
	private static Map<String, List<BookDTO>> wishListMap = new HashMap<>();

	public static Map<String, List<BookDTO>> getWishListMap() {
		return wishListMap;
	}

	public static void setWishListMap(Map<String, List<BookDTO>> wishListMap) {
		WishListUtil.wishListMap = wishListMap;
	}
}
