package com.example.demo.service.impl;

import com.example.demo.Util.RedisUtils;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Resource
    RedisUtils redisUtils;

    public Comparator<Book> comper(){
        return new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getBid()-o2.getBid();
                //结构体排序，按照bid升序
            }
        };
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = (List<Book>) redisUtils.get("allBook");
        if (books == null) {
            books = bookMapper.selectList(null);
            redisUtils.set("allBook", books);
        }
        return books;
    }

    @Override
    public void borrowBook(int bid,int sid){
        List<Book> books = (List<Book>) redisUtils.get("student" + sid + "book");
        if(books != null) {
            Book book = bookMapper.selectById(bid);
            books.add(book);
            books.sort(comper());
            redisUtils.set("student" + sid + "book",books);
        }
        bookMapper.borrowBook(bid,sid);
    }

    @Override
    public void changeBookIsAlive(int bid,int alive){
        List<Book> books = (List<Book>) redisUtils.get("allisalivebook");
        for(Book book:books) {
            if(book.getBid() == bid) {
                book.setIsalive(alive);
                break;
            }
        }
        redisUtils.set("allisalivebook",books);
        bookMapper.changeBookIsAlive(bid,alive);
    }

    @Override
    public void returnBook(int bid,int sid){
        List<Book> books = (List<Book>) redisUtils.get("student" + sid + "book");
        if(books != null) {
            Iterator<Book> iterator = books.iterator();
            while(iterator.hasNext()) {
                Book book = iterator.next();
                if(book.getBid() == bid) {
                    iterator.remove();
                    //从缓存中删除书本信息
                    break;
                }
            }
            books.sort(comper());
            //按书编号排序
            redisUtils.set("student" + sid + "book",books);
        }
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
