package com.example.Bioskop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RegistracijaDTO {
    private String username;
    private String lozinka;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private String datumrodjenja;
}
