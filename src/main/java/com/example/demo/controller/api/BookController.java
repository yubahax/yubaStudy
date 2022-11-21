package com.example.demo.controller.api;


import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Resource
    RedisUtils redisUtils;
    @Resource
    BookService bookService;

    @GetMapping("/returnBook")
    public void studentReturnBook(@RequestParam("bid") int bid) {
        int sid = redisUtils.getStudent().getSid();
        bookService.returnBook(bid,sid);
    }

    @GetMapping("/getStudentBook")
    public List<Book> getStudentBook(){
        int sid = redisUtils.getStudent().getSid();
        return bookService.getStudentBorrowedBooks(sid);
    }

    @GetMapping("/getAllBook")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping("/borrowBook")
    public void borrowBook(@RequestParam("bid") int bid) {
        int sid = redisUtils.getStudent().getSid();
        bookService.borrowBook(bid,sid);
    }

    @GetMapping("/searchBook")
    public List<Book> searchBook(@RequestParam("key") String key,@RequestParam("value") String value) {
        return  bookService.getBookByType(key,value);
    }

}
