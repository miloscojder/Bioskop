package com.example.Bioskop.service;

import com.example.Bioskop.model.Bioskop;
import com.example.Bioskop.repository.BioskopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BioskopService {
    @Autowired
    private BioskopRepository bioskopRepository;

    public void kreirajBioskop(Bioskop b){
        this.bioskopRepository.save(b);
    }
}
