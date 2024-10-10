package se.alex.lexicon.g51todoapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RESTExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDataNotFoundException( DataNotFoundException ex ) {
        ErrorDTO errorDTO = new ErrorDTO( HttpStatus.NOT_FOUND.value(), ex.getMessage() );
        return new ResponseEntity<>( errorDTO, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(DataDuplicateException.class)
    public ResponseEntity<ErrorDTO> handleDataDuplicateException( DataDuplicateException ex ) {
        ErrorDTO errorDTO = new ErrorDTO( HttpStatus.CONFLICT.value(), ex.getMessage() );
        return new ResponseEntity<>( errorDTO, HttpStatus.CONFLICT );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException( IllegalArgumentException ex ) {
        ErrorDTO errorDTO = new ErrorDTO( HttpStatus.BAD_REQUEST.value(), ex.getMessage() );
        return new ResponseEntity<>( errorDTO, HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGeneralException( Exception ex ) {
        ErrorDTO errorDTO = new ErrorDTO( HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred." );
        return new ResponseEntity<>( errorDTO, HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDataNotFound( DataNotFoundException ex ) {
        ErrorDTO error = new ErrorDTO( HttpStatus.NOT_FOUND.value(), ex.getMessage() );
        return new ResponseEntity<>( error, HttpStatus.NOT_FOUND );
    }


}
