package se.alex.lexicon.g51todoapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDTO {
    private int status;
    private String message;
}