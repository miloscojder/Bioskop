package com.example.Bioskop.repository;

import com.example.Bioskop.model.Rezervacije;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RezervacijeRepository extends JpaRepository<Rezervacije, Long> {
    List<Rezervacije> findAllByKorisnikkId(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from rezervacije r where r.id=:id")
    void deleteRezervacije(@Param("id") Long id);

}
