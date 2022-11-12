package com.library.rest.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.library.rest.service.dto.BookDTO;

@Service
public class ItemSearchServiceImpl implements ItemSearchService
{
    public List<BookDTO> searchBook(final String itemName) {
        final List<BookDTO> bookDTOList = this.getBookList();
        final String itemName2 = StringUtils.trimWhitespace(itemName);
        if (StringUtils.hasText(itemName)) {
            return bookDTOList.stream()
            		.filter(book -> book.getBookName().equalsIgnoreCase(itemName2))
            		.collect(Collectors.toList());
        }
        return List.of();
    }
    
    private List<BookDTO> getBookList() {
        final List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
        final BookDTO bookDTO1 = new BookDTO(Integer.valueOf(1), "A to Z", "Chiru", Double.valueOf(100.0), "Telugu");
        final BookDTO bookDTO2 = new BookDTO(Integer.valueOf(2), "My Journey", "Sachin", Double.valueOf(200.0), "Telugu");
        final BookDTO bookDTO3 = new BookDTO(Integer.valueOf(3), "Learning How to Fly", "APJ", Double.valueOf(300.0), "Telugu");
        bookDTOList.add(bookDTO1);
        bookDTOList.add(bookDTO2);
        bookDTOList.add(bookDTO3);
        return bookDTOList;
    }
}
