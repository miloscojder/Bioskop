package com.example.Bioskop.service;

import com.example.Bioskop.model.Korisnik;
import com.example.Bioskop.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik findOneByUsername(String username){ return this.korisnikRepository.findOneByUsername(username);}
    public void createKorisnik(Korisnik k){
        this.korisnikRepository.save(k);
    }

}