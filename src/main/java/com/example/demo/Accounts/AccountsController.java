package com.example.demo.Accounts;

import com.example.demo.Contrat.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AccountsController {
    private final AccountsService accountsService;
@Autowired
    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }
    /////////////////////
    @GetMapping
    public List<Accounts> getAllAccount() {
        return accountsService.getAllAccount();
    }
    @GetMapping("/{id}")
    public Optional<Accounts> getAccountById(@PathVariable Long id) {
        return accountsService.getAccountById(id);
    }

    @PostMapping
    public Accounts createAccount(@RequestBody Accounts account) {

        System.out.println("update client is made succefully");
        return accountsService.createAccount(account);
    }

    @PutMapping("/{id}")
    public Accounts updateAccount(@PathVariable Long id, @RequestBody Accounts updatedContrat) {
        return accountsService.updateAccount(id, updatedContrat);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountsService.deleteAccount(id);
    }

}
