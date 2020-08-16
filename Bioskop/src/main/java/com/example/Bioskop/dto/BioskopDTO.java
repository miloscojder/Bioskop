package com.example.Bioskop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BioskopDTO {
    private String naziv;
    private String adresa;
    private String brcentrale;
    private String email;
    private String menId;
    private String biosId;
}
