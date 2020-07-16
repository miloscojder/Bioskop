package com.example.Bioskop.repository;

import com.example.Bioskop.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findAll();
    List<Film> findAllByOrderByNazivAsc();
    List<Film> findAllByOrderByNazivDesc();
    List<Film> findAllByOrderByTrajanjeAsc();
    List<Film> findAllByOrderByTrajanjeDesc();
    List<Film> findAllByOrderByOcenaAsc();
    List<Film> findAllByOrderByOcenaDesc();
}
