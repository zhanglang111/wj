package com.evan.wj.Service;

import com.evan.wj.Pojo.Book;
import com.evan.wj.Pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/22
 */
@Service
public interface BookService {
    List<Book> findAllByCategory(int cid);
    List<Book> getAllBooks();
}
