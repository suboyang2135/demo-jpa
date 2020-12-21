package com.ikang.repository;

import com.ikang.entity.UserInfo;
import com.ikang.entity.UserInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xuyang
 * @date 2020/12/21 10:35
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, UserInfoId> {
}
