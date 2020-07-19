package com.example.Bioskop.repository;

import com.example.Bioskop.model.Korisnik;
import com.example.Bioskop.model.UlogaKorisnika;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {

    Korisnik findOneByUsername(String username);
    List<Korisnik> findAllByUloga(UlogaKorisnika uloga);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from korisnik k where k.id=:id")
    void deleteKorisnik(@Param("id") Long id);
}
