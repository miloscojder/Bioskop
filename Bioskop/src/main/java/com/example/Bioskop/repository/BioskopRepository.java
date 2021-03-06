package com.example.Bioskop.repository;

import com.example.Bioskop.model.Bioskop;
import com.example.Bioskop.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BioskopRepository extends JpaRepository<Bioskop, Long> {
    List<Bioskop> findAll();

    Bioskop findBioskopById(Long id);
    List<Bioskop> findAllByMenadzerId(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from bioskop b where b.id=:id")
    void deleteBioskop(@Param("id") Long id);

}
