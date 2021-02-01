package by.bsuir.photo.studio.api.repository;

import by.bsuir.photo.studio.api.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {

    List<UserRole> findByRoleId(String id);

    List<UserRole> findByUserId(String id);

}
