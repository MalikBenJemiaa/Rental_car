package com.example.demo.Facture;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FactureRepo extends JpaRepository<Facture,Long> {
    /*this to delete more than one facture in one time*/
    @Modifying
    @Transactional
    @Query("DELETE FROM Facture f WHERE f.id IN :factureIds")
    void deleteByFactureIds(@Param("factureIds") List<Long> factureIds);
}
