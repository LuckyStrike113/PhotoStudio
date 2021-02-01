package by.bsuir.photo.studio.api.repository;


import by.bsuir.photo.studio.api.entity.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HallRepository extends CrudRepository<Hall, String>, PagingAndSortingRepository<Hall, String> {


}