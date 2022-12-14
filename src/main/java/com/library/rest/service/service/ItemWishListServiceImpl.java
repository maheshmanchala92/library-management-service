package com.library.rest.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.library.rest.service.dto.BookDTO;
import com.library.rest.service.dto.WishListDTO;
import com.library.rest.service.utils.WishListUtil;

@Service
public class ItemWishListServiceImpl implements ItemWishListService {

	/*
	 * @Override public List<BookDTO> saveWishList(final WishListDTO wishListDTO) {
	 * Map<String, List<BookDTO>> wishListMap = WishListUtil.getWishListMap();
	 * wishListMap.put(wishListDTO.getUserId(), wishListDTO.getSelectedItems());
	 * return wishListDTO.getSelectedItems(); }
	 */

	@Override
	public List<BookDTO> getWishListByUserId(final String userId) {
		return WishListUtil.getWishListByUserId(userId);
	}

	@Override
	public List<BookDTO> removeWishList(final WishListDTO wishListDTO) {
		Map<String, List<BookDTO>> wishListMap = WishListUtil.getWishListMap();
		final String userId = wishListDTO.getUserId();
		List<BookDTO> existingWishList = wishListMap.get(userId);
		List<BookDTO> removeWishList = wishListDTO.getSelectedItems();

		List<Integer> bookIdList = removeWishList.stream().filter(book -> book.getBookId() != null)
				.map(book -> book.getBookId()).collect(Collectors.toList());

		existingWishList = existingWishList.stream().filter(book -> !bookIdList.contains(book.getBookId()))
				.collect(Collectors.toList());

		wishListMap.put(userId, existingWishList);
		return existingWishList;
	}


	@Override
	public List<BookDTO> updateWishList(WishListDTO wishListDTO) {
		
		Map<String, List<BookDTO>> wishListMap = WishListUtil.getWishListMap();
		
		final String userId = wishListDTO.getUserId();
		
		List<BookDTO> existingWishList = wishListMap.get(userId);
		
		List<BookDTO> updateWishList = wishListDTO.getSelectedItems();
		List<BookDTO> nonUpdatedWishList = new ArrayList<BookDTO>();
		if (existingWishList != null) {
			List<BookDTO> onlyUpdateWishSet = WishListUtil.getUpdatedWishList(existingWishList, updateWishList);

			List<Integer> bookIdSet = onlyUpdateWishSet.stream()
					.map(one -> one.getBookId())
					.collect(Collectors.toList());

			nonUpdatedWishList = existingWishList.stream()
					.filter(book -> !bookIdSet.contains(book.getBookId()))
					.collect(Collectors.toList());

			nonUpdatedWishList.addAll(onlyUpdateWishSet);
		}else {
			nonUpdatedWishList = updateWishList;
		}

		wishListMap.put(userId, nonUpdatedWishList);
		return nonUpdatedWishList;
	}

	@Override
	public Map<String, List<BookDTO>>  getAllUsersWishList() {
		return WishListUtil.getWishListMap();
	}

}
