package by.bsuir.photo.studio.api.service.impl;

import by.bsuir.photo.studio.api.entity.Hall;
import by.bsuir.photo.studio.api.repository.HallRepository;
import by.bsuir.photo.studio.api.service.HallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public Page<Hall> findAll(Pageable pageable) {
        return hallRepository.findAll(pageable);
    }

    @Override
    public Optional<Hall> findById(String id) {
        return hallRepository.findById(id);
    }

    @Override
    public Hall save(Hall hall) {
        return hallRepository.save(hall);
    }

    @Override
    public void deleteById(String id) {
        hallRepository.deleteById(id);
    }

    @Override
    public Hall update(Hall hall) {
        return hallRepository.save(hall);
    }

}
