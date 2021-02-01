package by.bsuir.photo.studio.api.service;

import by.bsuir.photo.studio.api.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface ContactService {

    Page<Contact> findAll(Pageable pageable);

    Optional<Contact> findById(String id);

    Contact save(Contact contact);

    void deleteById(String id);

    Contact update(Contact contact);
}