package com.wu.jdbc.jpa.domain.p;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity //说明此java类是实体类
@Table(name = "t_user")  //指定数据库对应的表
public class User implements Serializable {

    /**
     * @GeneratedValue:主键的产生策略，通过strategy属性指定。
     * 主键产生策略通过GenerationType来指定。GenerationType是一个枚举，它定义了主键产生策略的类型。
     * 1、AUTO：自动选择一个最适合底层数据库的主键生成策略。这个是默认选项，
     *      即如果只写@GeneratedValue，等价于@GeneratedValue(strategy=GenerationType.AUTO)。
     *      auto策略，也就是主键序列化,而mysql是不支持的 oracle支持的 所有在添加的时候才会报错 ,
     *      所以我们要主动设置id的策略 如MySQL会自动对应auto increment。
     * 2、IDENTITY：表自增长字段，Oracle不支持这种方式。
     * 3、SEQUENCE：通过序列产生主键，MySQL不支持这种方式。
     * 4、TABLE：通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植。不同的JPA实现商生成的表名是不同的，
     *      如 OpenJPA生成openjpa_sequence_table表，Hibernate生成一个hibernate_sequences表，
     *      而TopLink则生成sequence表。这些表都具有一个序列名和对应值两个字段，如SEQ_NAME和SEQ_COUNT。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

}
