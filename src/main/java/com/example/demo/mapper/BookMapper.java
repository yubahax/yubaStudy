package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    /**
     * 借书，向relationship表中添加（insert）一对借阅关系
     * @param bid 书编号
     * @param sid 学生学号
     */
    @Insert("insert into relationship(bid,sid) values(#{bid},#{sid})")
    void borrowBook(int bid,int sid);

    /**
     * 修改某一本图书的借阅状态（update）
     * @param bid 书编号
     * @param isalive 修改的状态，0为借出，1为未借出
     */
    @Update("update book set isalive = #{isalive} where bid = #{bid}")
    void changeBookIsAlive(int bid,int isalive);

    /**
     * 根据学号，查找当前学生借阅的所有图书信息
     * @param sid 学生学号
     * @return 当前学生借阅的所有书本信息
     */
    @Select("select * from book where bid in " +
            "(select bid from relationship where sid = #{sid})")
    List<Book> getStudentBorrowedBooks(int sid);

}
