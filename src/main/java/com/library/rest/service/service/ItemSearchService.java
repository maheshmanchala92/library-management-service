package com.library.rest.service.service;

import java.util.List;

import com.library.rest.service.dto.BookDTO;

public interface ItemSearchService {
	public List<BookDTO> searchBook(final String itemName);

	public List<BookDTO> getAllAvailableBooks();
}
