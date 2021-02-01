package by.bsuir.photo.studio.api.service.impl;

import by.bsuir.photo.studio.api.entity.Role;
import by.bsuir.photo.studio.api.entity.User;
import by.bsuir.photo.studio.api.repository.RoleRepository;
import by.bsuir.photo.studio.api.repository.UserRepository;
import by.bsuir.photo.studio.api.repository.UserRoleRepository;
import by.bsuir.photo.studio.api.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = userRoleRepository.findByUserId(user.getId()).stream()
                .map(ur -> {
                    Role role = roleRepository.findById(ur.getRoleId()).orElseThrow(EntityNotFoundException::new);
                    return new SimpleGrantedAuthority("ROLE_" + role.getName());
                })
                .collect(Collectors.toList());


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
