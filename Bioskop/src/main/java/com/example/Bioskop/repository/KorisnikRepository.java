package com.example.Bioskop.repository;

import com.example.Bioskop.model.Korisnik;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {

    Korisnik findOneByUsername(String username);
}
