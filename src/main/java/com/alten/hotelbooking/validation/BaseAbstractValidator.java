package com.alten.hotelbooking.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.alten.hotelbooking.exception.BadRequestException;
import org.springframework.util.StringUtils;

public abstract class BaseAbstractValidator<T extends Serializable> implements Validator<T> {

    private Set<Condition> conditions;
    private Set<Rule> rules;
    private Set<Validator> subValidators;

    public void validate(T request) {
        List<String> violations = getViolations(request);

        if (!violations.isEmpty()) {
            throw new BadRequestException(violations);
        }
    }


    public List<String> getViolations(T request) {
        List<String> violations = new ArrayList<>();
        if (getConditions().stream().filter(condition -> condition.isValid(request)).count() == getConditions().size()) {

            addViolationMessagesFromRules(request, violations);
            addViolationMessagesFromSubvalidators(request, violations);
        }
        return violations;
    }


    protected void addCondition(Condition condition) {
        getConditions().add(condition);
    }

    protected void addRule(Rule rule) {
        getRules().add(rule);
    }

    protected void addSubvalidator(Validator validator) {
        getSubValidators().add(validator);
    }

    private Set<Condition> getConditions() {
        if (conditions == null) {
            conditions = new HashSet<>();
        }
        return conditions;
    }

    public Set<Rule> getRules() {
        if (rules == null) {
            rules = new HashSet<>();
        }
        return rules;
    }

    public Set<Validator> getSubValidators() {
        if (subValidators == null) {
            subValidators = new HashSet<>();
        }
        return subValidators;
    }

    private void addViolationMessagesFromSubvalidators(T request, List<String> violations) {

        violations.addAll(
                getSubValidators().stream()
                        .map(validator -> validator.getViolations(request))
                        .reduce((m1, m2) -> {
                            m1.addAll(m2);
                            return m1;
                        })
                        .orElse(new ArrayList())
        );
    }

    private void addViolationMessagesFromRules(T request, List<String> violations) {
        violations.addAll(getRules().stream()
                .map(rule -> rule.applyRule(request))
                .filter(message -> !StringUtils.isEmpty(message))
                .collect(Collectors.toList()));
    }
}
