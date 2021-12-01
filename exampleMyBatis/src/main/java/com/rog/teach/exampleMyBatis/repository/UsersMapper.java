package com.rog.teach.exampleMyBatis.repository;

import com.rog.teach.exampleMyBatis.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> findAll();

    @Insert("insert into users(id,name,salary) values(nextval('users_id_seq'), #{name},#{salary})")
//    @SelectKey(statement = "select nextval('users_id_seq')", keyProperty = "id",
//            before = true, resultType = Integer.class)
    void insert(Users users);
}