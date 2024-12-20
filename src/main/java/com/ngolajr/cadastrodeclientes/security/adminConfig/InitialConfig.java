package com.ngolajr.cadastrodeclientes.security.adminConfig;

import com.ngolajr.cadastrodeclientes.model.Role;
import com.ngolajr.cadastrodeclientes.model.User;
import com.ngolajr.cadastrodeclientes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitialConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Admin");
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRoles(Set.of(Role.ADMIN, Role.USER, Role.MANAGER));
        if(userRepository.findByUsername("admin").isEmpty())
            userRepository.save(user);
    }
}
