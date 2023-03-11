package com.aorez.dao.impl;

import com.aorez.dao.BookDao;
import com.aorez.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("BookDaoImpl save");
    }

    @Override
    public User getById(int id) {
        return null;
    }
}
