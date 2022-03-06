package com.ingjulianvega.testspecification.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserException extends RuntimeException {

    private HttpStatus httpStatus;
    private String apiCode;
    private String error;
    private String message;
    private String solution;
}

