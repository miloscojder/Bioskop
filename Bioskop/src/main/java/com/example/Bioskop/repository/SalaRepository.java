package com.example.Bioskop.repository;

import com.example.Bioskop.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    Sala findOneById(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from sala b where b.id=:id")
    void deleteSala(@Param("id") Long id);

}
