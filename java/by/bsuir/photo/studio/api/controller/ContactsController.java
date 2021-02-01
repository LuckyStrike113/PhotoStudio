package by.bsuir.photo.studio.api.controller;

import by.bsuir.photo.studio.api.entity.Contact;
import by.bsuir.photo.studio.api.service.ContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contacts")
public class ContactsController {

    private final ContactService contactService;

    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public Page<Contact> getAllContacts(Pageable pageable) {
        return contactService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        return ResponseEntity.of(contactService.findById(id));
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@RequestBody Contact contact, @PathVariable String id) {
        contact.setId(id);
        return contactService.update(contact);
    }

    @DeleteMapping("/{id}")
    public void removeContact(@PathVariable String id) {
        contactService.deleteById(id);
    }
}