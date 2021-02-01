package by.bsuir.photo.studio.api.configuration;

import by.bsuir.photo.studio.api.repository.*;
import by.bsuir.photo.studio.api.service.ContactService;
import by.bsuir.photo.studio.api.service.HallGalleryService;
import by.bsuir.photo.studio.api.service.HallService;
import by.bsuir.photo.studio.api.service.UserService;
import by.bsuir.photo.studio.api.service.impl.ContactServiceImpl;
import by.bsuir.photo.studio.api.service.impl.HallGalleryServiceImpl;
import by.bsuir.photo.studio.api.service.impl.HallServiceImpl;
import by.bsuir.photo.studio.api.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private HallGalleryRepository hallGalleryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public ContactService contactService() {
        return new ContactServiceImpl(contactRepository);
    }

    @Bean
    public HallService hallService() {
        return new HallServiceImpl(hallRepository);
    }

    @Bean
    public HallGalleryService hallGalleryService() {
        return new HallGalleryServiceImpl(hallGalleryRepository);
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository, roleRepository, userRoleRepository);
    }
}