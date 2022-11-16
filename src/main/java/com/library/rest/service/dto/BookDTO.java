package com.library.rest.service.dto;

import lombok.Data;

@Data
public class BookDTO
{
    private Integer bookId;
    private String bookName;
    private String bookAuthorName;
    private Double price;
    private String language;
    private Integer quantity;
    
    public BookDTO() {
    }
    
    public BookDTO(final String bookName, final String bookAuthorName){
    	this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
    }
    
    public BookDTO(final Integer bookId, final String bookName, final String bookAuthorName, final Double price, final String language) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.price = price;
        this.language = language;
    }
    
    public BookDTO(final Integer bookId, final String bookName, final String bookAuthorName, final Double price, final String language, final Integer quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.price = price;
        this.language = language;
        this.quantity = quantity;
    }
}
