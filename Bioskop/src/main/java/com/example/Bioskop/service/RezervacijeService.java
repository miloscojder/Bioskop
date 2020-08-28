package com.example.Bioskop.service;

import com.example.Bioskop.model.Rezervacije;
import com.example.Bioskop.repository.ProjekcijaRepository;
import com.example.Bioskop.repository.RezervacijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RezervacijeService {
    @Autowired
    private RezervacijeRepository rezervacijeRepository;

    public void saveRezervaciju(Rezervacije r){this.rezervacijeRepository.save(r);}
}
