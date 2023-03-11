package com.aorez.dao;

import com.aorez.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
    public void save();

    @Select("select * from user where id=#{id}")
    public User getById(int id);
}
