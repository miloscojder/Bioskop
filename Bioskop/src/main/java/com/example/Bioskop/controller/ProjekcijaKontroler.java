package com.example.Bioskop.controller;

import com.example.Bioskop.dto.BioskopDTO;
import com.example.Bioskop.dto.ProjekcijaDTO;
import com.example.Bioskop.model.Bioskop;
import com.example.Bioskop.model.Korisnik;
import com.example.Bioskop.model.Projekcija;
import com.example.Bioskop.model.Sala;
import com.example.Bioskop.service.FilmService;
import com.example.Bioskop.service.ProjekcijaService;
import com.example.Bioskop.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/projekcija")
public class ProjekcijaKontroler {
    @Autowired
    private ProjekcijaService projekcijaService;
    @Autowired
    private SalaService salaService;
    @Autowired
    private FilmService filmService;

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/ucitajProjekcije/{id}")
    public ResponseEntity<?> ucitajProjekcije(@PathVariable("id") String id){
        List<Sala> sale = this.salaService.findAllByBioskop(Long.parseLong(id));
        List<Projekcija> projekcije = new ArrayList<Projekcija>();
        List<ProjekcijaDTO> dto = new ArrayList<ProjekcijaDTO>();
        //System.out.println("Pred ulaz!!!!!!!!!!!!!!");
        for(Sala s : sale){
           // System.out.println("SALA JE : "+s.getId());
            for(Projekcija p : this.projekcijaService.findAllBySalaId(s.getId())) {
               // System.out.println("USAO JE U PROJEKCIJE");
                projekcije.add(p);
            }
        }
        for(Projekcija p : projekcije){
            ProjekcijaDTO projekcijaDTO = ProjekcijaDTO.builder().cena(p.getCena()).datum(p.getVremeprojekcije()).id(p.getId()).nazivFilma(p.getFilmmm()
                    .getNaziv()).oznakaSale(p.getSalaa().getOznakasale()).bioskopId(Long.parseLong(id)).build();
            dto.add(projekcijaDTO);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/izmeniProjekciju")
    public ResponseEntity<?> izmeniProjekciju(@RequestBody ProjekcijaDTO dto){
        Projekcija p = this.projekcijaService.findOneById(dto.getId());
        p.setCena(dto.getCena());

        Sala s = this.salaService.findOneByOznakasale(dto.getOznakaSale());
        List<Projekcija> projekcijaList = this.projekcijaService.findAllBySalaId(s.getId());
        System.out.println("DATUM JEEEEEEE: "+dto.getDatum());
        for(Projekcija pr : projekcijaList){
            if(pr.getVremeprojekcije().compareTo(dto.getDatum()) == 0){
                System.out.println("NASAO IH JEEEEEE");
                return new ResponseEntity<>("Zauzet datum", HttpStatus.BAD_REQUEST);
            }
        }
        p.setVremeprojekcije(dto.getDatum());
        p.setSalaa(this.salaService.findOneByOznakasale(dto.getOznakaSale()));
        p.setFilmmm(this.filmService.findOneByNaziv(dto.getNazivFilma()));
        this.projekcijaService.save(p);
        return new ResponseEntity<>( HttpStatus.OK);

    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/dodajProjekciju")
    public ResponseEntity<?> dodajProjekciju(@RequestBody ProjekcijaDTO dto){
        Projekcija p = new Projekcija();
        p.setCena(dto.getCena());

        Sala s = this.salaService.findOneByOznakasale(dto.getOznakaSale());
        List<Projekcija> projekcijaList = this.projekcijaService.findAllBySalaId(s.getId());
        //System.out.println("DATUM JEEEEEEE: "+dto.getDatum());
        for(Projekcija pr : projekcijaList){
            if(pr.getVremeprojekcije().compareTo(dto.getDatum()) == 0){
               // System.out.println("NASAO IH JEEEEEE");
                return new ResponseEntity<>("Zauzet datum", HttpStatus.BAD_REQUEST);
            }
        }
        p.setVremeprojekcije(dto.getDatum());
        p.setSalaa(this.salaService.findOneByOznakasale(dto.getOznakaSale()));
        p.setFilmmm(this.filmService.findOneByNaziv(dto.getNazivFilma()));
        this.projekcijaService.save(p);
        return new ResponseEntity<>( HttpStatus.OK);

    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/ucitajProjekcijeFilma/{id}")
    public ResponseEntity<?> ucitajProjekcijeFilma(@PathVariable("id") String id){
        List<ProjekcijaDTO> dto = new ArrayList<ProjekcijaDTO>();
        List<Projekcija> projekcijaList = this.projekcijaService.findAllByFilmId(Long.parseLong(id));
        for(Projekcija p : projekcijaList){
            ProjekcijaDTO projekcija = ProjekcijaDTO.builder().cena(p.getCena()).datum(p.getVremeprojekcije()).nazivFilma(p.getFilmmm().getNaziv()).oznakaSale(p.getSalaa().getOznakasale()).build();
            dto.add(projekcija);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
