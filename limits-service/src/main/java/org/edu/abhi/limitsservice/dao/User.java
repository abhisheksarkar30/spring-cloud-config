package org.edu.abhi.limitsservice.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String username, password;
    private String[] roles;
}