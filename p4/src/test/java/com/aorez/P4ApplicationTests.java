package com.aorez;

import com.aorez.dao.BookDao;
import com.aorez.domain.Book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class P4ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testSelectById() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setName("数据库系统概念");
        book.setType("计算机");
        book.setDescription("数据库");
        int n = bookDao.insert(book);
        System.out.println(n);
    }

    @Test
    void testPage() {
        IPage<Book> page = new Page<>(2, 2);
        bookDao.selectPage(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }

    @Test
    void testQuery() {
        String queryType = "计算机";
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("type", queryType);
        IPage<Book> page = new Page<>();
        bookDao.selectPage(page, queryWrapper);

        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Book::getName, queryType);
        bookDao.selectPage(page, lambdaQueryWrapper);

        queryType = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(queryType!=null, Book::getName, queryType);
        bookDao.selectPage(page, lqw);
    }

}
