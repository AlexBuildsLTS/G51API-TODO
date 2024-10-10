package se.alex.lexicon.g51todoapi.startup;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener {

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady( ) {

        System.out.println( "Application is ready to accept requests." );
    }
}
