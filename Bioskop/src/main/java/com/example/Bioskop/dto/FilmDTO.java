package com.example.Bioskop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FilmDTO {
    private String naziv;
    private String opis;
    private String zanr;
    private int trajanje;
    private double ocena;
}
