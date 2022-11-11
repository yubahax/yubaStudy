package com.example.demo.service.impl;

import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Resource
    RedisUtils redisUtils;

    @Override
    public List<Book> getAllIsAliveBook() {
        List<Book> books = (List<Book>) redisUtils.get("allisalivebook");
        if (books == null) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("isalive", 1);
            books = bookMapper.selectByMap(map);
            redisUtils.set("allisalivebook", books);
        }
        return books;
    }

    @Override
    public void borrowBook(int bid,int sid){
        bookMapper.borrowBook(bid,sid);
    };

    @Override
    public void changeBookIsAlive(int bid,int alive){
        bookMapper.changeBookIsAlive(bid,alive);
    }

    @Override
    public void returnBook(int bid,int sid){
        bookMapper.returnBook(bid, sid);
    };

    @Override
    public List<Book> getStudentBorrowedBooks(int sid) {
        List<Book> books = (List<Book>) redisUtils.get("student"+sid+"book");
        if(books == null) {
            books = bookMapper.getStudentBorrowedBooks(sid);
            redisUtils.set("student" + sid + "book", books);
        }
        return books;
    };

}
