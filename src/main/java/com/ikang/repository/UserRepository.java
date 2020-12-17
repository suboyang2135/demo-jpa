package com.ikang.repository;

import com.ikang.dto.UserEmailNameDTO;
import com.ikang.dto.UserOnlyName;
import com.ikang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author xuyang
 * @date 2020/12/16 17:45
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);

    List<User> findByEmailAndFirstName(String email, String firstName);

    // 包含 distinct 去重，or 的 sql 语法
    List<User> findDistinctByFirstNameOrLastName(String firstName, String lastName);

    // 根据 lastname 字段查询忽略大小写
    List<User> findByLastNameIgnoreCase(String lastName);

    // 根据 lastname 和 firstname 查询 equal 并且忽略大小写
    List<User> findByLastNameAndFirstNameIgnoreCase(String lastName, String firstName);

    // 查询结果根据lastName 排序，倒叙
    List<User> findByLastNameOrderByFirstNameDesc(String lastName);

    // 查询结果根据lastName 排序，正叙
    List<User> findByLastNameOrderByFirstNameAsc(String lastName);

    // 统计 lastName 的数量
    long countByLastName(String lastName);

    // 根据lastName删除数据
    long deleteByLastName(String lastName);

    // 根据lastName删除数据，同时返回删除的数据
    List<User> removeByLastName(String lastName);

    UserEmailNameDTO findByEmail(String email);

    UserOnlyName findByAddress(String address);

}
