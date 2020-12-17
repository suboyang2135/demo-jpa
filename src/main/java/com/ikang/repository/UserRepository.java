package com.ikang.repository;

import com.ikang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xuyang
 * @date 2020/12/16 17:45
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByEmailAndName(String email, String name);

}
