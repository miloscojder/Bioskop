package com.example.Bioskop.service;

import com.example.Bioskop.model.Rezervacije;
import com.example.Bioskop.repository.ProjekcijaRepository;
import com.example.Bioskop.repository.RezervacijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class RezervacijeService {
    @Autowired
    private RezervacijeRepository rezervacijeRepository;

    public void saveRezervaciju(Rezervacije r){this.rezervacijeRepository.save(r);}
    public List<Rezervacije> findAllByKorisnikkId(Long id){ return this.rezervacijeRepository.findAllByKorisnikkId(id);}
    public void deleteRezervacija(Long id){ this.rezervacijeRepository.deleteRezervacije(id);}
}
