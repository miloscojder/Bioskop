package com.example.Bioskop.controller;

import com.example.Bioskop.dto.KorisnikDTO;
import com.example.Bioskop.dto.RegistracijaDTO;
import com.example.Bioskop.model.Korisnik;
import com.example.Bioskop.model.UlogaKorisnika;
import com.example.Bioskop.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/korisnik")
public class KorisnickiKontroler {

    @Autowired
    private KorisnikService korisnikService;

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/login")
    public ResponseEntity<?> logovanje(@RequestBody KorisnikDTO podaci){
        Korisnik k = korisnikService.findOneByUsername(podaci.getUsername());
        if(k!=null){
            if(k.getLozinka().equals(podaci.getPassword())) return new ResponseEntity<>(k,HttpStatus.OK);
        }
        return new ResponseEntity<>(k, HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/registracija")
    public ResponseEntity<?> reg(@RequestBody RegistracijaDTO reg){
        Korisnik k = Korisnik.builder().username(reg.getUsername()).lozinka(reg.getLozinka()).ime(reg.getIme()).prezime(reg.getPrezime())
                .email(reg.getEmail()).telefon(reg.getTelefon()).datumrodjenja(new Date()).aktivan(true).uloga(UlogaKorisnika.GLEDAOC).build();
        this.korisnikService.createKorisnik(k);
        return new ResponseEntity<>(k, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/menadzeri")
    public ResponseEntity<?> ispisiMenadzere(){
        String ulogaMen = "MENADZER";
        return new ResponseEntity<>(this.korisnikService.findAllByUloga(ulogaMen), HttpStatus.OK);
    }

}
