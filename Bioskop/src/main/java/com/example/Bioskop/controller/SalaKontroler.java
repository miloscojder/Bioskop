package com.example.Bioskop.controller;

import com.example.Bioskop.dto.RegistracijaDTO;
import com.example.Bioskop.dto.SalaDTO;
import com.example.Bioskop.model.*;
import com.example.Bioskop.service.BioskopService;
import com.example.Bioskop.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/sale")
public class SalaKontroler {
    @Autowired
    private SalaService salaService;
    @Autowired
    private BioskopService bioskopService;

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getSale/{id}")
    public ResponseEntity<?> vratiSale(@PathVariable("id") String id){
        return new ResponseEntity<>(this.salaService.findAllByBioskop(Long.parseLong(id)), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/sala/{id}")
    public ResponseEntity<?> sale(@PathVariable("id") String id){
        return new ResponseEntity<>(this.salaService.findSalaById(Long.parseLong(id)), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/izmeniSalu")
    public ResponseEntity<?> men(@RequestBody SalaDTO salaDTO){
        Sala s = this.salaService.findSalaById(salaDTO.getId());
        s.setKapacitet(Integer.parseInt(salaDTO.getKapacitet()));
        s.setOznakasale(salaDTO.getOznakaSale());

        this.salaService.saveSala(s);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/brisiSalu/{id}")
    public ResponseEntity<?> brisiSalu(@PathVariable("id") String id){
        this.salaService.deleteSala(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/dodajSalu")
    public ResponseEntity<?> dodaj(@RequestBody SalaDTO salaDTO){
        Sala s = Sala.builder().kapacitet(Integer.parseInt(salaDTO.getKapacitet())).oznakasale(salaDTO.getOznakaSale()).build();
        this.salaService.saveSala(s);
        Bioskop b = this.bioskopService.findBioskopById(salaDTO.getId());
        Bioskop_sala bs = Bioskop_sala.builder().sala(s).bioskop(b).build();
        this.salaService.saveBioskopSala(bs);
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
}
