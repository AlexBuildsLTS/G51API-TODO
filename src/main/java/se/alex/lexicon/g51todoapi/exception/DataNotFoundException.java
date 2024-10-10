package se.alex.lexicon.g51todoapi.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException( String message ) {
        super( message );
    }
}
