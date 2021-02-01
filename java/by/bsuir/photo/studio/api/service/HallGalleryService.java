package by.bsuir.photo.studio.api.service;

import by.bsuir.photo.studio.api.entity.HallGallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HallGalleryService {

    Page<HallGallery> findAll(Pageable pageable);

    Optional<HallGallery> findById (String id);

    HallGallery save(HallGallery hallGallery);

    void deleteById(String id);

    HallGallery update(HallGallery hallGallery);

}
