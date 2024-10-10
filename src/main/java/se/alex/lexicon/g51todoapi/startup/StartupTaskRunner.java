package se.alex.lexicon.g51todoapi.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupTaskRunner implements CommandLineRunner {

    @Override
    public void run( String... args ) throws Exception {

        System.out.println( "Application has started. Running custom startup tasks..." );

    }
}
