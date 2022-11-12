package com.library.rest.service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.json.JSONObject;
import com.library.rest.service.dto.BookDTO;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import com.library.rest.service.service.ItemSearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/item" })
public class ItemSearchController {
	private ItemSearchService itemSearchService;

	public ItemSearchController(final ItemSearchService itemSearchService) {
		this.itemSearchService = itemSearchService;
	}

	@PostMapping(value = { "/search" }, consumes = { "application/json" })
	public List<BookDTO> searchBook(@RequestBody final String searchDTO) {
		final JSONObject jsonObject = new JSONObject("");
		final String itemName = jsonObject.getString("itemName");
		final List<BookDTO> bookDTOList = (List<BookDTO>) this.itemSearchService.searchBook(itemName);
		return bookDTOList;
	}
}
