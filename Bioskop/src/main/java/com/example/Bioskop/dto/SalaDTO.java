package com.example.Bioskop.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SalaDTO {
    private Long id;
    private String kapacitet;
    private String oznakaSale;
}
