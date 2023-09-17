package com.carstorewithspring.exception;

import java.util.Collections;
import java.util.List;

public class ExceptionService {
    private final List<String> errors;

    public ExceptionService(List<String> errors) {
        this.errors = errors;
    }

    public ExceptionService(String message) {
        this.errors = Collections.singletonList(message);
    }

    public List<String> getErrors(){
        return errors;
    }
}
