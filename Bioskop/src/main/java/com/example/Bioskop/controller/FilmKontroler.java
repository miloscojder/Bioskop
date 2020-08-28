package com.example.Bioskop.controller;


import com.example.Bioskop.dto.FilmDTO;
import com.example.Bioskop.model.Film;
import com.example.Bioskop.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//import java.awt.*;

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
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/pretrazi")
    public ResponseEntity<?> pretraga(@RequestBody FilmDTO dto) {
        List<Film> filmList = this.filmService.findAll();
        List<Film> filmd = new ArrayList<Film>();

        if(!dto.getNaziv().equals("")){
            for(Film f : filmList){
                if(f.getNaziv().toLowerCase().startsWith(dto.getNaziv().toLowerCase())){
                    filmd.add(f);
                }
            }
        }else filmd.addAll(filmList);

        //System.out.println("OCENA JEEEEEE: "+dto.getOcena());
        List<Film> pomocnaList = new ArrayList<Film>();
        if(dto.getOcena() != 0.0){
            for(Film f : filmd){
               // System.out.println("ISECENI DOUBLE: "+ (int) dto.getOcena());
               // System.out.println("ISECENI DOUBLE: "+ (int) f.getOcena());
                int ocenaFilma = (int) f.getOcena();
                int unetaOcena = (int) dto.getOcena();
                if(ocenaFilma != unetaOcena){
                    pomocnaList.add(f);
                }
            }
            filmd.removeAll(pomocnaList);
        }

        List<Film> pomocnaList2 = new ArrayList<Film>();
        if(!dto.getOpis().equals("")){
            for(Film f : filmd){
                if(!f.getOpis().toLowerCase().startsWith(dto.getOpis().toLowerCase())){
                    pomocnaList2.add(f);
                }
            }
            filmd.removeAll(pomocnaList2);
        }

        List<Film> pomocnaList3 = new ArrayList<Film>();
        if(!dto.getZanr().equals("")){
            for(Film f : filmd){
                if(!f.getZanr().toLowerCase().startsWith(dto.getZanr().toLowerCase())){
                    pomocnaList3.add(f);
                }
            }
            filmd.removeAll(pomocnaList3);
        }

        List<Film> pomocnaLista4 = new ArrayList<Film>();
        if(dto.getTrajanje() != 0){
            for(Film f : filmd){
                if(f.getTrajanje() != dto.getTrajanje() ){
                    pomocnaLista4.add(f);
                }
            }
            filmd.removeAll(pomocnaLista4);
        }

        return new ResponseEntity<>(filmd, HttpStatus.OK);
    }
}
