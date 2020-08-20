package com.example.Bioskop.service;

import com.example.Bioskop.model.Projekcija;
import com.example.Bioskop.model.Sala;
import com.example.Bioskop.repository.ProjekcijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjekcijaService {
    @Autowired
    private ProjekcijaRepository projekcijaRepository;

    public List<Projekcija> findAllBySalaId(Long id){
        //System.out.println("USAO JE U FJUUUU");
        return this.projekcijaRepository.findAllBySalaaId(id);
    }

    public Projekcija findOneById(Long id){return this.projekcijaRepository.findOneById(id);}
    public void save(Projekcija p){this.projekcijaRepository.save(p);}
}
