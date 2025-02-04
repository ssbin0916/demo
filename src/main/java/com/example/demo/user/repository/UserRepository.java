package com.example.demo.user.repository;

import com.example.demo.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {

    @Insert("""
            insert into user (id, name, dept, reg_dtm) values (#{id}, #{name}, #{dept}, CURRENT_TIMESTAMP(0))
            """)
    void save(User user);

    @Select("""
            select * from user where id = #{id}
            """)
    List<User> findById(String id);
}