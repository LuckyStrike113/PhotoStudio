package by.bsuir.photo.studio.api.repository;

import by.bsuir.photo.studio.api.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends CrudRepository<Contact, String>, PagingAndSortingRepository<Contact, String> {


}
