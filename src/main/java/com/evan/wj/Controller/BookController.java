package com.evan.wj.Controller;

import com.alibaba.fastjson.JSONObject;
import com.evan.wj.Pojo.Book;
import com.evan.wj.Service.BookService;
import com.evan.wj.Service.CategoryService;
import com.evan.wj.Utils.ResultUtil;
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

    @PostMapping("/admin/content/books/delete")
    public Object deleteBookById(@RequestBody Book book){
        if(bookService.deleteBookById(book.getId())!=0){
            return ResultUtil.OK();
        }else{
            return ResultUtil.error(500,"删除失败");
        }
    }

    @PostMapping("/searchBooksByKeyword")
    public Object searchBooksByKeyword(@RequestBody String keywords){
        //把一个参数写两遍？

        List<Book> books = bookService.searchBooksByKeyword(keywords);
        return books;
    }
}
