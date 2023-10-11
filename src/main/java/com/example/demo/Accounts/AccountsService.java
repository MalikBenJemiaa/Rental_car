package com.example.demo.Accounts;

import com.example.demo.Contrat.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {
    private final AccountsRepo accountsRepo;
    @Autowired

    public AccountsService(AccountsRepo accountsRepo) {
        this.accountsRepo = accountsRepo;
    }
    /////////////////////////////////////
    public List<Accounts> getAllAccount() {
        return accountsRepo.findAll();
    }
    public Optional<Accounts> getAccountById(Long id) {
        return accountsRepo.findById(id);
    }
    public Accounts createAccount(Accounts account) {
        return accountsRepo.save(account);
    }

    public Accounts updateContrat(Long id, Accounts updatedAccount) {
        Optional<Accounts> existingAccount = accountsRepo.findById(id);
        if (existingAccount.isPresent()) {
            Accounts accountToUpdate = existingAccount.get();
            accountToUpdate.setUsername(updatedAccount.getUsername());
            accountToUpdate.setEmail(updatedAccount.getEmail());
            accountToUpdate.setPassword(updatedAccount.getPassword());


            // You can update other properties as needed
            return accountsRepo.save(accountToUpdate);
        } else {
            throw new RuntimeException("Account not found with id: " + id);
        }
    }
    public void deleteAccount(Long id) {
        accountsRepo.deleteById(id);
    }

}
