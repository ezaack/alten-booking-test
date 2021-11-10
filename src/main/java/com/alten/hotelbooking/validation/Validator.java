package com.alten.hotelbooking.validation;

import java.io.Serializable;
import java.util.List;

public interface Validator<T extends Serializable> {

    void validate(T request);
    List<String> getViolations(T request);
}
