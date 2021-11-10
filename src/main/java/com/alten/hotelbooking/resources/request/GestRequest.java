package com.alten.hotelbooking.resources.request;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GestRequest implements Serializable {
    private String name;
    private Integer age;
    private Boolean mainGest;
}
