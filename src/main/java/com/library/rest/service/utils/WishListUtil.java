package com.library.rest.service.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.library.rest.service.dto.BookDTO;

public class WishListUtil {
	private static Map<String, List<BookDTO>> wishListMap = new HashMap<>();

	public static Map<String, List<BookDTO>> getWishListMap() {
		return wishListMap;
	}

	public static void setWishListMap(Map<String, List<BookDTO>> wishListMap) {
		WishListUtil.wishListMap = wishListMap;
	}

	public static List<BookDTO> getWishListByUserId(String userId) {
		return wishListMap.get(userId);
	}

	public static List<BookDTO> getUpdatedWishList(List<BookDTO> listOne, List<BookDTO> listTwo) {
		// We create a stream of elements from the first list.
		List<Integer> listOneBookIds = listOne.stream()
		.map(book->book.getBookId())
		.collect(Collectors.toList());
		
		List<BookDTO> updateWishList = listTwo.stream()
				// We select any elements such that in the stream of elements from the second
				// list
				.filter(two -> listOne.stream()
						// there is an element that has the same name and school as this element,
						.anyMatch(one -> one.getBookId().equals(two.getBookId())
								&& !two.getQuantity().equals(one.getQuantity())
								|| !listOneBookIds.contains(two.getBookId())
								))

				// and collect all matching elements from the first list into a new list.
				.collect(Collectors.toList());
		// We return the collected list.
		return updateWishList;
	}
}