package com.rog.teach.exampleMyBatis.controller;

import com.rog.teach.exampleMyBatis.entity.Users;
import com.rog.teach.exampleMyBatis.repository.UsersMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/users")
public class UsersController {

    private final UsersMapper usersMapper;

    public UsersController(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @GetMapping("all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @PostMapping("insert")
    public void insertUsers(@RequestBody Users users) {
        usersMapper.insert(users);
    }

}
