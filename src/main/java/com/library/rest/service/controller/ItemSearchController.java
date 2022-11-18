package com.library.rest.service.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.rest.service.dto.BookDTO;
import com.library.rest.service.dto.ResponseDTO;
import com.library.rest.service.service.ItemSearchService;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class ItemSearchController {

	private ItemSearchService itemSearchService;

	public ItemSearchController(final ItemSearchService itemSearchService) {
		this.itemSearchService = itemSearchService;
	}

	@PostMapping(value = "/search", consumes = "application/json")
	public ResponseDTO searchBookByName(@RequestBody final String itemName) {
		final JSONObject jsonObject = new JSONObject(itemName);
		final String itemNameValue = jsonObject.getString("itemName");
		if (StringUtils.hasText(itemNameValue)) {
			List<BookDTO> bookList = itemSearchService.searchBook(itemNameValue.trim());
			return new ResponseDTO("Success", bookList, HttpStatus.OK);
		}
		return new ResponseDTO("Error", "Please enter valid itemName.", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/search/all")
	public ResponseDTO getAllAvailableBooks() {
		List<BookDTO> bookList = itemSearchService.getAllAvailableBooks();
		return new ResponseDTO("Success", bookList, HttpStatus.OK);
	}

}
