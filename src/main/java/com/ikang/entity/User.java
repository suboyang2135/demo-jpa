package com.ikang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author xuyang
 * @date 2020/12/16 17:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "r_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String address;


}
