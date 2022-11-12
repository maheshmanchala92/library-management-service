package com.library.rest.service.utils;

import java.util.ArrayList;
import java.util.List;

import com.library.rest.service.dto.BookDTO;

public class BookUtils {

	static final List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
	
	public static List<BookDTO> getBookList() {
        
        final BookDTO bookDTO1 = new BookDTO(1, "A to Z", "Chiru", 100.00, "Telugu");
        final BookDTO bookDTO2 = new BookDTO(2, "My Journey", "Sachin", 200.00, "Telugu");
        final BookDTO bookDTO3 = new BookDTO(3, "Learning How to Fly", "APJ", 300.00, "Telugu");
        bookDTOList.add(bookDTO1);
        bookDTOList.add(bookDTO2);
        bookDTOList.add(bookDTO3);
        return bookDTOList;
    }
}
