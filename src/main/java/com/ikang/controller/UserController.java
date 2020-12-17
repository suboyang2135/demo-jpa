package com.ikang.controller;

import com.ikang.entity.User;
import com.ikang.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xuyang
 * @date 2020/12/16 17:47
 */
@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserRepository userRepository;

    @PostMapping(value = "/")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping(value = "/all")
    public Page<User> getAllUsers(Pageable request) {
        return userRepository.findAll(request);
    }

    @GetMapping(value = "/page")
    public Page<User> getAllUsersByPage() {
        return userRepository.findAll(PageRequest.of(1, 20, Sort.by(new Sort.Order(Sort.Direction.DESC, "name"))));
    }

    @GetMapping(path = "/sort")
    public Iterable<User> getAllUsersWithSort() {
        return userRepository.findAll(Sort.by(new Sort.Order(Sort.Direction.ASC, "name")));
    }

}
