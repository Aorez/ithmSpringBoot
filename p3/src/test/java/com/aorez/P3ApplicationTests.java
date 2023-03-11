package com.aorez;

import com.aorez.dao.UserDao;
import com.aorez.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class P3ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        User user = userDao.getById(1);
        System.out.println(user);

        User user2 = userDao.selectById(2);
        System.out.println(user2);
    }

}
