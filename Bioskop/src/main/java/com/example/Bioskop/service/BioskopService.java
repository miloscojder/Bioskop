package com.example.Bioskop.service;

import com.example.Bioskop.model.Bioskop;
import com.example.Bioskop.repository.BioskopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class BioskopService {
    @Autowired
    private BioskopRepository bioskopRepository;

    public void kreirajBioskop(Bioskop b){
        this.bioskopRepository.save(b);
    }
    public List<Bioskop> findAll(){ return this.bioskopRepository.findAll();}
    public void brisiBioskop(Long id){this.bioskopRepository.deleteBioskop(id);}
}
