package by.bsuir.photo.studio.api.controller;

import by.bsuir.photo.studio.api.entity.HallGallery;
import by.bsuir.photo.studio.api.service.HallGalleryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/halls/gallery")
public class HallsGalleryController {

    private final HallGalleryService hallGalleryService;

    public HallsGalleryController(HallGalleryService hallGalleryService) {
        this.hallGalleryService = hallGalleryService;
    }

    @GetMapping
    public Page<HallGallery> getAllHallsGallery(Pageable pageable) {
        return hallGalleryService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HallGallery> getHallGallery(@PathVariable String id) {
        return ResponseEntity.of(hallGalleryService.findById(id));
    }

    @PostMapping
    public HallGallery createHallGallery(@RequestBody HallGallery hallGallery) {
        return hallGalleryService.save(hallGallery);
    }

    @PutMapping("/{id}")
    public HallGallery updateHallGallery(@RequestBody HallGallery hallGallery, @PathVariable String id) {
        hallGallery.setId(id);
        return hallGalleryService.update(hallGallery);
    }

    @DeleteMapping("/{id}")
    public void removeHallGallery(@PathVariable String id) {
        hallGalleryService.deleteById(id);
    }

}