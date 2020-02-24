package com.evan.wj.Mapper;

import com.evan.wj.Pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Code by langlang on 2020/2/22
 */
@Mapper
public interface BookMapper {
    @Select("SELECT\n" +
            "book.id,\n" +
            "book.cover,\n" +
            "book.title,\n" +
            "book.author,\n" +
            "book.date,\n" +
            "book.press,\n" +
            "book.abs,\n" +
            "book.cid\n" +
            "FROM\n" +
            "book\n" +
            "WHERE\n" +
            "book.cid = #{cid}")
    List<Book> findAllByCategory(int cid);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);

    @Select("SELECT\n" +
            "*\n" +
            "FROM\n" +
            "book\n")
    public List<Book> getAllBooks();

    @Insert("INSERT INTO book(book.cover,book.title,book.author,book.date,book.press,book.abs,book.cid) VALUES(" +
            "#{cover},#{title},#{author},#{date},#{press},#{abs},#{cid})")
    public int addBook(Book book);

    @Delete("DELETE FROM book WHERE book.id = #{id}")
    public int deleteBookById(int id);


    @Select("SELECT * FROM book WHERE book.title LIKE concat('%',#{keywords},'%')")
    public List<Book> searchBooksByKeyword(String keywords);

}
