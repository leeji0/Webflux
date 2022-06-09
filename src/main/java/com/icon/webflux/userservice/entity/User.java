package com.icon.webflux.userservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("users")
public class User {

    @Id
    private Integer id;
    private String name;
    private Integer balance;

}
