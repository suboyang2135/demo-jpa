package com.ikang.repository;

import com.ikang.ApplicationTests;
import com.ikang.entity.UserInfo;
import com.ikang.entity.UserInfoId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


/**
 * @author xuyang
 * @date 2020/12/21 10:36
 */
public class UserInfoRepositoryTest extends ApplicationTests {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void findById() {
        userInfoRepository.save(UserInfo.builder().age(26).name("jack").telephone("18611111111").build());
        Optional<UserInfo> userInfo = userInfoRepository.findById(UserInfoId.builder().name("jack").telephone("18611111111").build());
        UserInfo info = userInfo.orElse(null);
        assert null != info;
    }
}