package com.alten.hotelbooking.validation;

import java.io.Serializable;

public interface Condition<T extends Serializable> {

    Boolean isValid(T request);
}
