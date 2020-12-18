package com.ikang.repository;

import com.ikang.ApplicationTests;
import com.ikang.dto.UserEmailNameDTO;
import com.ikang.dto.UserOnlyName;
import com.ikang.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuyang
 * @date 2020/12/17 10:02
 */
public class UserRepositoryTest extends ApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Resource
    private UserRepository userRepository;

    @Test
    public void save() {
        User user = new User();
        user.setEmail("tom123@163.com");
        user.setFirstName("tom");
        user.setLastName("rale");
        user.setAddress("beijing");
        User save = userRepository.save(user);
        assert null != save.getId();
    }

    @Test
    public void findByName() {
        String firstName = "jack";
        List<User> users = userRepository.findByFirstName(firstName);
        assert CollectionUtils.isNotEmpty(users);
    }

    @Test
    public void findByEmailAndName() {
        String firstName = "jack";
        String email = "jack123@163.com";
        List<User> users = userRepository.findByEmailAndFirstName(email, firstName);
        assert CollectionUtils.isNotEmpty(users);
    }

    @Test
    public void findByLastNameIgnoreCase() {
        String lastName = "RALE";
        List<User> users = userRepository.findByLastNameIgnoreCase(lastName);
        assert CollectionUtils.isNotEmpty(users);
    }

    @Test
    public void countByLastName() {
        String lastName = "rale";
        long count = userRepository.countByLastName(lastName);
        assert count == 1;
    }

    @Test
    public void deleteByLastName() {
        String lastName = "rale";
        long deleteCount = userRepository.deleteByLastName(lastName);
        assert deleteCount == 1;
    }

    @Test
    public void removeByLastName() {
        String lastName = "rale";
        List<User> users = userRepository.removeByLastName(lastName);
        assert CollectionUtils.isNotEmpty(users);
    }

    @Test
    public void findByEmail() {
        String email = "jack123@163.com";
        UserEmailNameDTO emailNameDTO = userRepository.findByEmail(email);
        assert null != emailNameDTO;
    }

    @Test
    public void findByAddress() {
        String address = "beijing";
        UserOnlyName userOnlyName = userRepository.findByAddress(address);
        logger.info(userOnlyName.getLastName());
        logger.info(userOnlyName.getEmail());
    }

    @Test
    public void findByQuery() {
        String nameParam = "tom";
        User user = userRepository.findByQuery(nameParam);
        assert null != user;
    }
}