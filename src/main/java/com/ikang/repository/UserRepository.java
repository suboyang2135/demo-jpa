package com.ikang.repository;

import com.ikang.dto.UserEmailNameDTO;
import com.ikang.dto.UserOnlyName;
import com.ikang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // 以下为@query注解使用
    @Query("from r_user where firstName = :name")
    User findByQuery(@Param("name") String nameParam);

    // @Query("select u from r_user u where u.email = ?1")
    // User findByEmailAddress(String email);

    @Query(value = "select u.* from r_user u where u.email = ?1", nativeQuery = true)
    User findByEmailAddress(String email);

    // 模糊后缀查询
    @Query("select u from r_user u where u.firstName like %?1")
    List<User> findByFirstNameEndsWith(String firstName);

    // @Query推介用法
    @Query("select u from r_user u where u.firstName = :firstName or u.lastName = :lastName")
    User findByFirstNameOrLastName(@Param("firstName") String firstName,
                                   @Param("lastName") String lastName);

}
