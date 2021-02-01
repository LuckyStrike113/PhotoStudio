package by.bsuir.photo.studio.api.service;

import by.bsuir.photo.studio.api.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User create(User user);

    Page<User> findAll(Pageable pageable);

    void deleteById(String id);

    User update(User user);


}
