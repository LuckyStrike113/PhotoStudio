package by.bsuir.photo.studio.api.service.impl;

import by.bsuir.photo.studio.api.entity.HallGallery;
import by.bsuir.photo.studio.api.repository.HallGalleryRepository;
import by.bsuir.photo.studio.api.service.HallGalleryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class HallGalleryServiceImpl implements HallGalleryService {

    private final HallGalleryRepository hallGalleryRepository;

    public HallGalleryServiceImpl(HallGalleryRepository hallGalleryRepository) {
        this.hallGalleryRepository = hallGalleryRepository;
    }

    @Override
    public Page<HallGallery> findAll(Pageable pageable) {
        return hallGalleryRepository.findAll(pageable);
    }

    @Override
    public Optional<HallGallery> findById(String id) {
        return Optional.empty();
    }

    @Override
    public HallGallery save(HallGallery hallGallery) {
        return hallGalleryRepository.save(hallGallery);
    }

    @Override
    public void deleteById(String id) {
        hallGalleryRepository.deleteById(id);
    }

    @Override
    public HallGallery update(HallGallery hallGallery) {
        return hallGalleryRepository.save(hallGallery);
    }

}