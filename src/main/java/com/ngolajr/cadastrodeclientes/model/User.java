package com.ngolajr.cadastrodeclientes.model;

import com.ngolajr.cadastrodeclientes.model.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String password;
    @OneToMany
    private Set<Role> roles;

    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.name());
        user.setUsername(userDto.username());
        user.setPassword(userDto.password());
        Set<Role> roles = Set.of(Role.USER);

        return user;
    }
}
