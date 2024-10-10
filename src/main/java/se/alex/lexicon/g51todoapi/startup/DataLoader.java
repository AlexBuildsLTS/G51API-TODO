package se.alex.lexicon.g51todoapi.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.alex.lexicon.g51todoapi.entity.Role;
import se.alex.lexicon.g51todoapi.repository.RoleRepository;

@Configuration
public class DataLoader {

    private final RoleRepository roleRepository;

    @Autowired
    public DataLoader( RoleRepository roleRepository ) {
        this.roleRepository = roleRepository;
    }

    @Bean
    ApplicationRunner init( ) {
        return args -> {
            // will check if roles exist
            if (roleRepository.count() == 0) {
                Role adminRole = new Role( "ROLE_ADMIN" );
                Role userRole = new Role( "ROLE_USER" );
                roleRepository.save( adminRole );
                roleRepository.save( userRole );
                System.out.println( "Preloaded initial roles." );
            }
        };
    }
}
