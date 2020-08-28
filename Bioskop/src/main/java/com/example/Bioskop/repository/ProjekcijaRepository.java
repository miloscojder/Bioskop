package com.example.Bioskop.repository;

import com.example.Bioskop.model.Projekcija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjekcijaRepository extends JpaRepository<Projekcija, Long> {
    List<Projekcija> findAllBySalaaId(Long id);
    Projekcija findOneById(Long id);
    List<Projekcija> findAllByFilmmmId(Long id);
}
