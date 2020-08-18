package com.example.Bioskop.repository;

import com.example.Bioskop.model.Bioskop_sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BioskopSalaRepository extends JpaRepository<Bioskop_sala, Long> {
    List<Bioskop_sala> findAllByBioskopId(Long id);

}
