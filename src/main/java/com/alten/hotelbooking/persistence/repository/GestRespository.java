package com.alten.hotelbooking.persistence.repository;

import java.util.UUID;

import com.alten.hotelbooking.persistence.entity.Gest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestRespository extends JpaRepository<Gest, UUID> {
}
