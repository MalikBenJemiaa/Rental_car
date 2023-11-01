package com.example.demo.Accounts;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountsRepo extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findAccountsByUsername(String username);
    Optional<Accounts> findByUsernameAndPassword(String username, String password);
    @Query("select  a from Accounts a where a.worken= false ")
    Optional<List<Accounts>> findBlockedAccount();
    @Modifying
    @Transactional
    @Query("UPDATE Accounts a set a.worken=true where a.id= :idCar")
    void UpdateWorkenToTure(@Param("idCar") Long id);

}
