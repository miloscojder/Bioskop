package com.example.Bioskop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @JsonIgnore
    private String lozinka;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private Date datumrodjenja;
    @Enumerated(EnumType.STRING)
    private UlogaKorisnika uloga;
    private boolean aktivan;


    @OneToMany(mappedBy = "menadzer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Bioskop> bioskop = new HashSet<Bioskop>();

    @OneToMany(mappedBy = "korisnik", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Korisnik_film> korisnici = new HashSet<Korisnik_film>();

    @OneToMany(mappedBy = "korisnikk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Rezervacije> rezervacije = new HashSet<Rezervacije>();






}
