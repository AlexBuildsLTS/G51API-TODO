package se.alex.lexicon.g51todoapi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder {
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


}
