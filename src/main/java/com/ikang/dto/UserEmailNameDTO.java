package com.ikang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 返回实体DTO对象的时候只能有一个全参构造方法
 * @author xuyang
 * @date 2020/12/17 14:16
 */
@Data
@Builder
@AllArgsConstructor
public class UserEmailNameDTO {

    private String firstName;

    private String lastName;

    private String email;
}
