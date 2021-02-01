package by.bsuir.photo.studio.api.repository;

import by.bsuir.photo.studio.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<User, String>, PagingAndSortingRepository<User, String> {

    User findByUsername(String username);

}
