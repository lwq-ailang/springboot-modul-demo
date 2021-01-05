package com.wu.jdbc.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_user")
public class UserEntity {

    @Id
    private Long id;
    private String name;
    private Integer age;

}