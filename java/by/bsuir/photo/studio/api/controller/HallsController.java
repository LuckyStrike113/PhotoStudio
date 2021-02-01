package by.bsuir.photo.studio.api.controller;

import by.bsuir.photo.studio.api.entity.Hall;
import by.bsuir.photo.studio.api.service.HallService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/halls")
public class HallsController {

    private final HallService hallService;

    public HallsController(HallService hallService) {
        this.hallService = hallService;
    }


    @GetMapping
    public Page<Hall> getAllHalls(Pageable pageable) {
        return hallService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHall(@PathVariable String id) {
        return ResponseEntity.of(hallService.findById(id));
    }

    @PostMapping
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.save(hall);
    }

    @PutMapping("/{id}")
    public Hall updateHall(@RequestBody Hall hall, @PathVariable String id) {
        hall.setId(id);
        return hallService.update(hall);
    }

    @DeleteMapping("/{id}")
    public void removeHall(@PathVariable String id) {
        hallService.deleteById(id);
    }

}