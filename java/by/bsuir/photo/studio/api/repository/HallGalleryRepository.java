package by.bsuir.photo.studio.api.repository;

import by.bsuir.photo.studio.api.entity.HallGallery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HallGalleryRepository extends CrudRepository<HallGallery, String>,
        PagingAndSortingRepository<HallGallery, String> {


}