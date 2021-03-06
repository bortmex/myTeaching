package com.rog.teach.repos;

import com.rog.teach.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String name);

    User findByEmail(String name);

    User findByActivationCode(String code);
}
