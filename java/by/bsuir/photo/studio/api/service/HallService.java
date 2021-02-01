package by.bsuir.photo.studio.api.service;

import by.bsuir.photo.studio.api.entity.Hall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface HallService {

    Page<Hall> findAll(Pageable pageable);

    Optional<Hall> findById(String id);

    Hall save(Hall hall);

    void deleteById(String id);

    Hall update(Hall hall);
}