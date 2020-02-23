package com.evan.wj.Controller;

import com.alibaba.fastjson.JSONObject;
import com.evan.wj.Pojo.Book;
import com.evan.wj.Service.BookService;
import com.evan.wj.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Code by langlang on 2020/2/22
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories/{cid}/books")
    public List<JSONObject> getBooksBycategories(@PathVariable("cid") int cid){

        List<JSONObject> jsonObjectList = new ArrayList<>();
        List<Book> books = bookService.findAllByCategory(cid);
        for (Book book:books) {
            jsonObjectList.add((JSONObject) JSONObject.toJSON(book));
        }
        return jsonObjectList;
    }

    @GetMapping("/getAllBooks")
    public List<JSONObject> getAllBooks(){

        List<JSONObject> jsonObjectList = new ArrayList<>();
        List<Book> books = bookService.getAllBooks();
        for (Book book:books) {
            jsonObjectList.add((JSONObject) JSONObject.toJSON(book));
        }
        return jsonObjectList;
    }

    @PostMapping("/addBook")
    public int addBook(@RequestBody Book book){
        int i= bookService.addBook(book);
        return i;
    }

    @GetMapping("/deleteBookById/{id}")
    public int deleteBookById(@PathVariable int id){
        int i= bookService.deleteBookById(id);
        return i;
    }
}
