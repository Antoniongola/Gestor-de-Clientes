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

    public void userDtoToUser(UserDto userDto) {
        //checking if the attributes from the dto aren't empty
        if(!userDto.name().isEmpty())
            this.name = userDto.name();
        if(!userDto.username().isEmpty())
            this.username = userDto.username();
        if(!userDto.password().isEmpty())
            this.password = userDto.password();

        //by default, the user is a common user.
        this.roles = Set.of(Role.USER);
    }
}
