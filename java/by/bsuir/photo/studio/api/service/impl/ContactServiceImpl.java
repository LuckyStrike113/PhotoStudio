package by.bsuir.photo.studio.api.service.impl;

import by.bsuir.photo.studio.api.entity.Contact;
import by.bsuir.photo.studio.api.repository.ContactRepository;
import by.bsuir.photo.studio.api.service.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Page<Contact> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public Optional<Contact> findById(String id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(String id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }
}
