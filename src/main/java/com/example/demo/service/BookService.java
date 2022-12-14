package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * 返回数据库中所有1的图书
     * @return 图书实体类
     */
    public List<Book> getAllBook();

    /**
     * 借书，向relationship表中添加（insert）一对借阅关系
     * @param bid 书编号
     * @param sid 学生学号
     */
    public void borrowBook(int bid,int sid);

    /**
     * 修改某一本图书的借阅状态（update）
     * @param bid 书编号
     * @param alive 修改的状态，0为借出，1为未借出
     */
    public void changeBookIsAlive(int bid,int alive);

    /**
     * 还书，从表中删除借阅关系（delete）
     * @param bid 书编号
     * @param sid 学生学号
     */
    public void returnBook(int bid,int sid);

    /**
     * 根据学号，查找当前学生借阅的所有图书信息
     * @param sid 学生学号
     * @return 当前学生借阅的所有书本信息
     */
    public List<Book> getStudentBorrowedBooks(int sid);

    /**
     * 图书馆查询接口 根据key value查询对应图书信息
     * @param key 查询字段
     * @param value 字段值
     * @return 查询出的图书信息
     */
    public List<Book> getBookByType(String key,String value);
}
