package com.evan.wj.Service;

import com.evan.wj.Pojo.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/22
 */
@Service
public interface BookService {
    List<Book> findAllByCategory(int cid);
    List<Book> getAllBooks();
    public int addBook(Book book);
    public int deleteBookById(int id);
    public List<Book> searchBooksByKeyword(String keywords);
}
