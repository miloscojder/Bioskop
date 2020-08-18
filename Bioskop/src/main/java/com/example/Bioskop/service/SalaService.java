package com.example.Bioskop.service;

import com.example.Bioskop.model.Bioskop_sala;
import com.example.Bioskop.model.Sala;
import com.example.Bioskop.repository.BioskopSalaRepository;
import com.example.Bioskop.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.*;
@Transactional
@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private BioskopSalaRepository bioskopSalaRepository;

    public List<Sala> findAllByBioskop(Long id){
        List<Bioskop_sala> lista = this.bioskopSalaRepository.findAllByBioskopId(id);
        List<Sala> ret = new ArrayList<Sala>();
        for(Bioskop_sala bs : lista){
            //System.out.println("Elem bios get id sale "+ bs.getSala().getId());
            ret.add(this.salaRepository.findOneById(bs.getSala().getId()));
        }
        return ret;
    }
    public Sala findSalaById(Long id) {return this.salaRepository.findOneById(id);}
    public void saveSala(Sala s){this.salaRepository.save(s);}
    public void deleteSala(Long id){this.salaRepository.deleteSala(id);}
    public void saveBioskopSala(Bioskop_sala bs){this.bioskopSalaRepository.save(bs);}
}
