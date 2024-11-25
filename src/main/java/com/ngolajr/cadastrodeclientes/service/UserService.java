package com.ngolajr.cadastrodeclientes.service;

import com.ngolajr.cadastrodeclientes.model.Role;
import com.ngolajr.cadastrodeclientes.model.User;
import com.ngolajr.cadastrodeclientes.model.dto.UserDto;
import com.ngolajr.cadastrodeclientes.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Data
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User newUser(UserDto dto) {
        User user = new User();
        user.userDtoToUser(dto);
        if(userRepository.findByUsername(dto.username()).isEmpty())
            return userRepository.save(user);

        return null;
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public Page<User> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public List<User> findAllUsersByRole(String role) {
        return userRepository.findAllByRolesContaining(Role.valueOf(role.toUpperCase()));
    }

    public User updateUser(long id, UserDto dto) {
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        Set<Role> roles = user.getRoles();
        user.userDtoToUser(dto);
        user.setId(id);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User promoteUser(long id) {
        Set<Role> newRoles = Set.of(Role.USER, Role.MANAGER);
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        user.setRoles(newRoles);
        return userRepository.save(user);
    }

    public User demoteUser(long id) {
        Set<Role> newRoles = Set.of(Role.USER);
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        user.setRoles(newRoles);
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
