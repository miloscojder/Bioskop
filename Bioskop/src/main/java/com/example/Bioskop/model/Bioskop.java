package com.example.Bioskop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Bioskop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String adresa;
    private String brCentrale;
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "menadzer_id")
    @JsonBackReference
    private Korisnik menadzer;

    @OneToMany(mappedBy = "bioskop", fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JsonManagedReference
    private Set<Bioskop_sala> sale = new HashSet<Bioskop_sala>();

    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Bioskop_sala> sale2 = new HashSet<Bioskop_sala>();





}
