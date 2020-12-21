package com.ikang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author xuyang
 * @date 2020/12/21 10:34
 */
@Entity
@Data
@Builder
@IdClass(value = UserInfoId.class)
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private Integer age;

    @Id
    private String name;

    @Id
    private String telephone;

}
