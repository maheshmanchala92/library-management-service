package com.library.rest.service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.library.rest.service.dto.BookDTO;
import com.library.rest.service.utils.BookUtils;

@Service
public class ItemSearchServiceImpl implements ItemSearchService
{
	@Override
    public List<BookDTO> searchBook(final String itemName) {
        final List<BookDTO> bookDTOList = BookUtils.getBookList();
        final String itemName2 = StringUtils.trimWhitespace(itemName);
        if (StringUtils.hasText(itemName)) {
            return bookDTOList.stream()
            		.filter(book -> book.getBookName().equalsIgnoreCase(itemName2))
            		.collect(Collectors.toList());
        }
        return List.of();
    }

	@Override
	public List<BookDTO> getAllAvailableBooks() {
		return BookUtils.getBookList();
	}
}
