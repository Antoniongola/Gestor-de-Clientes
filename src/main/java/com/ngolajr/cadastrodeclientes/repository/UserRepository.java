package com.ngolajr.cadastrodeclientes.repository;

import com.ngolajr.cadastrodeclientes.model.Role;
import com.ngolajr.cadastrodeclientes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRolesContaining(Role role);
    Optional<User> findByUsername(String username);

}
