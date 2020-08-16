package com.example.Bioskop.controller;

import com.example.Bioskop.dto.BioskopDTO;
import com.example.Bioskop.model.Bioskop;
import com.example.Bioskop.model.Korisnik;
import com.example.Bioskop.service.BioskopService;
import com.example.Bioskop.service.KorisnikService;
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
    @Autowired
    private KorisnikService korisnikService;

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/kreiraj")
    public ResponseEntity<?> kreirajBioskop(@RequestBody BioskopDTO dto){
        System.out.println("ID je: "+dto.getMenId());
        Korisnik k = korisnikService.findOneByUsername(dto.getMenId());
        System.out.println(k);
        Bioskop b = Bioskop.builder().adresa(dto.getAdresa()).brcentrale(dto.getBrcentrale()).email(dto.getEmail()).naziv(dto.getNaziv()).menadzer(k).build();
        this.bioskopService.kreirajBioskop(b);
        return new ResponseEntity<>(b, HttpStatus.OK);

    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/bioskopi")
    public ResponseEntity<?> ispisiBioskope(){
        return new ResponseEntity<>(this.bioskopService.findAll(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/brisiBioskop/{id}")
    public ResponseEntity<?> brisiBioskop(@PathVariable("id") String id){
        this.bioskopService.brisiBioskop(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/vratiBioskop/{id}")
    public ResponseEntity<?> vratiBioskop(@PathVariable("id") String id){
        return new ResponseEntity<>(this.bioskopService.findBioskopById(Long.parseLong(id)),HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/izmeniBioskop")
    public ResponseEntity<?> izmeniBioskop(@RequestBody BioskopDTO dto){
        System.out.println("ID je: "+dto.getMenId());
        Korisnik k = korisnikService.findOneByUsername(dto.getMenId());
        System.out.println(k);
        Bioskop b = this.bioskopService.findBioskopById(Long.parseLong(dto.getBiosId()));
        b.setNaziv(dto.getNaziv());
        b.setAdresa(dto.getAdresa());
        b.setEmail(dto.getEmail());
        b.setBrcentrale(dto.getBrcentrale());
        b.setMenadzer(k);
        this.bioskopService.kreirajBioskop(b);
        return new ResponseEntity<>(b, HttpStatus.OK);

    }


}
