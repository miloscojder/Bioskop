package com.example.Bioskop.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RezervacijeDTO {
    private Long id;
    private String nazivFilma;
    private Date datum;
}
