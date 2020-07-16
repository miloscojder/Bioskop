package com.example.Bioskop.controller;


import com.example.Bioskop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/film")
public class FilmKontroler {
    @Autowired
    private FilmService filmService;

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/ucitaj")
    public ResponseEntity<?> ucitavanje(){
        return new ResponseEntity<>(this.filmService.findAll(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/sortiraj/{par}")
    public ResponseEntity<?> sortiranje(@PathVariable("par") String tip) {
        if (tip.equals("a-z")) return new ResponseEntity<>(this.filmService.findAllOrderByNazivAsc(), HttpStatus.OK);
        else  if (tip.equals("z-a")) return new ResponseEntity<>(this.filmService.findAllOrderByNazivDesc(), HttpStatus.OK);
        else  if (tip.equals("trajuz")) return new ResponseEntity<>(this.filmService.findAllOrderByTrajanjeAsc(), HttpStatus.OK);
        else  if (tip.equals("trajiz")) return new ResponseEntity<>(this.filmService.findAllOrderByTrajanjeDesc(), HttpStatus.OK);
        else  if (tip.equals("ocenauz")) return new ResponseEntity<>(this.filmService.findAllOrderByOcenaAsc(), HttpStatus.OK);
        else  return new ResponseEntity<>(this.filmService.findAllOrderByOcenaDesc(), HttpStatus.OK);
    }
}
