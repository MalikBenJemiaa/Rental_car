package com.example.demo.Contrat;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractRepo extends JpaRepository<Contrat,Long> {
    /*@Modifying*/
    @Transactional
    @Query("SELECT c.facture.id FROM Contrat c WHERE c.location.id IN :locationIds")
    List<Long> findFactureIdsByLocationIds(@Param("locationIds") List<Long> locationIds);
    @Modifying
    @Transactional
    @Query("DELETE FROM Contrat c WHERE c.location.id IN :locationIds")
    void deleteAllByLocationIds(@Param("locationIds") List<Long> locationIds);
}
