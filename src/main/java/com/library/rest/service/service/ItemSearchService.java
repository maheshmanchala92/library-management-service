// 
// Decompiled by Procyon v0.5.36
// 

package com.library.rest.service.service;

import com.library.rest.service.dto.BookDTO;
import java.util.List;

public interface ItemSearchService
{
    List<BookDTO> searchBook(final String itemName);
}
