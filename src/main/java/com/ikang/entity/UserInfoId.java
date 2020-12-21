package com.ikang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xuyang
 * @date 2020/12/21 10:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoId implements Serializable {

    private String name, telephone;

}
