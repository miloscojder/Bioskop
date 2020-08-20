package com.example.Bioskop.service;

import com.example.Bioskop.model.Film;
import com.example.Bioskop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> findAll(){return this.filmRepository.findAll(); };
    public  List<Film> findAllOrderByNazivAsc(){return this.filmRepository.findAllByOrderByNazivAsc(); }
    public  List<Film> findAllOrderByNazivDesc(){return this.filmRepository.findAllByOrderByNazivDesc(); }
    public  List<Film> findAllOrderByTrajanjeAsc(){return this.filmRepository.findAllByOrderByTrajanjeAsc(); }
    public  List<Film> findAllOrderByTrajanjeDesc(){return this.filmRepository.findAllByOrderByTrajanjeDesc(); }
    public  List<Film> findAllOrderByOcenaAsc(){return this.filmRepository.findAllByOrderByOcenaAsc(); }
    public  List<Film> findAllOrderByOcenaDesc(){return this.filmRepository.findAllByOrderByOcenaDesc(); }
    public Film findOneByNaziv(String naziv){return this.filmRepository.findOneByNaziv(naziv);}


}
