package com.alten.hotelbooking.validation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseAbstractRule<T extends Serializable> implements Rule<T> {

    private Set<Condition> conditions;

    @Override
    public String applyRule(T request) {
        if (getConditions().stream().filter(condition -> condition.isValid(request)).count() == getConditions().size()) {
            return violationMessage(request);
        }
        return null;
    }

    protected abstract String violationMessage(T request);

    protected void addCondition(Condition condition) {
        getConditions().add(condition);
    }

    private Set<Condition> getConditions() {
        if (conditions == null) {
            conditions = new HashSet<>();
        }
        return conditions;
    }
}
