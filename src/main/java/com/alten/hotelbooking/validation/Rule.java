package com.alten.hotelbooking.validation;

import java.io.Serializable;

public interface Rule<T extends Serializable> {


    String applyRule(T request);
}
