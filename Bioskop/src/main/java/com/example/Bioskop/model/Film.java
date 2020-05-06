package com.example.Bioskop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String opis;
    private String zanr;
    private int trajanje;
    private double ocena;

    @OneToMany(mappedBy = "film",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Korisnik_film> filmovi = new HashSet<Korisnik_film>();

    @OneToMany(mappedBy = "filmm",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Korisnik_film> filmovi2 = new HashSet<Korisnik_film>();

}
