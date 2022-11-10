package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> getAllIsAliveBook() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isalive",1);
        return bookMapper.selectByMap(map);
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
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bid",bid);
        map.put("sid",sid);
        bookMapper.deleteByMap(map);
    };

    @Override
    public List<Book> getStudentBorrowedBooks(int sid) {
        return bookMapper.getStudentBorrowedBooks(sid);
    };

}
