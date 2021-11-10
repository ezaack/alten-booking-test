package com.alten.hotelbooking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_gest")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gest implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    private String name;
    private Integer age;
    @Column(name="main_gest", nullable = false)
    private Boolean mainGest;
    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;

}
