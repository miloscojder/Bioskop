package com.example.Bioskop.controller;

import com.example.Bioskop.model.Film;
import com.example.Bioskop.model.Korisnik;
import com.example.Bioskop.model.Rezervacije;
import com.example.Bioskop.service.FilmService;
import com.example.Bioskop.service.KorisnikService;
import com.example.Bioskop.service.RezervacijeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping(value = "/rezervacije")
public class RezervacijeKontroler {
    @Autowired
    private RezervacijeService rezervacijeService;
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private FilmService filmService;

    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";


    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/rezervisiProjekcijeFilma/{id}")
    public ResponseEntity<?> rezervisiProjekcijeFilma(@PathVariable("id") String id) throws ParseException {
        Film f = this.filmService.findOneByNaziv(id.split(",")[0]);

       // System.out.println("DATUM JE VAKI "+ id.split(",")[1].split("T")[0]);
       // System.out.println("SAT JE VAKI "+ id.split(",")[1].split("T")[1]);
       // System.out.println("Milisek JE VAKI "+ id.split(",")[1].split("T")[1].split("\\.")[0]);
        Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(""+id.split(",")[1].split("T")[0]+" "+id.split(",")[1].split("T")[1].split("\\.")[0]);
        System.out.println("DATUM JE VAKI "+ d.toString());
        Korisnik k = this.korisnikService.findOneByUlogovan();
        Rezervacije r = Rezervacije.builder().datumrezervacije(d).filmm(f).korisnikk(k).build();
        this.rezervacijeService.saveRezervaciju(r);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
