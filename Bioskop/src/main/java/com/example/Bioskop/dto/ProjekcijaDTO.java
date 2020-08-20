package com.example.Bioskop.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProjekcijaDTO {
    private Long id;
    private Date datum;
    private Double cena;
    private String nazivFilma;
    private String oznakaSale;
    private Long bioskopId;
}
