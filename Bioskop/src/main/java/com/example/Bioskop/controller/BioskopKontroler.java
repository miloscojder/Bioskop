package com.example.Bioskop.controller;

import com.example.Bioskop.dto.BioskopDTO;
import com.example.Bioskop.model.Bioskop;
import com.example.Bioskop.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/bioskop")
public class BioskopKontroler {
    @Autowired
    private BioskopService bioskopService;

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/kreiraj")
    public ResponseEntity<?> kreirajBioskop(@RequestBody BioskopDTO dto){
        Bioskop b = Bioskop.builder().adresa(dto.getAdresa()).brcentrale(dto.getBrcentrale()).email(dto.getEmail()).naziv(dto.getNaziv()).build();
        this.bioskopService.kreirajBioskop(b);
        return new ResponseEntity<>(b, HttpStatus.OK);

    }

}
