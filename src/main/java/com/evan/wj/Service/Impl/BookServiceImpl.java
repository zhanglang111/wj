package com.evan.wj.Service.Impl;

import com.evan.wj.Mapper.BookMapper;
import com.evan.wj.Pojo.Book;
import com.evan.wj.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Code by langlang on 2020/2/22
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findAllByCategory(int cid) {
        return bookMapper.findAllByCategory(cid);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public List<Book> searchBooksByKeyword(String keywords) {
        List<Book> books = bookMapper.searchBooksByKeyword(keywords);
        return books;
    }
}
