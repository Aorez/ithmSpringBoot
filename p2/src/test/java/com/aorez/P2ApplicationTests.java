package com.aorez;

import com.aorez.dao.BookDao;
import com.aorez.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class P2ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        bookDao.save();
        User user = bookDao.getById(1);
        System.out.println(user);
    }

}
