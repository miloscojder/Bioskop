package com.example.Bioskop.model;

import lombok.Getter;

@Getter
public enum UlogaKorisnika {
    GLEDAOC("GLEDAOC"), MENADZER("MENADZER"), ADMIN("ADMIN");

    private String uloga;

    UlogaKorisnika(String uloga) {
        this.uloga = uloga;
    }
}
