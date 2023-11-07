package com.example.demo.Accounts;

import com.example.demo.Contrat.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AccountsController {
    private final AccountsService accountsService;
@Autowired
    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }
    /////////////////////
    @GetMapping("/secure/admin/GetAllAccounts")
    public List<Accounts> getAllAccount() {
        return accountsService.getAllAccount();
    }
    @GetMapping("/secure/admin/GetOneAccount/{id}")
    public Optional<Accounts> getAccountById(@PathVariable Long id) {
        return accountsService.getAccountById(id);
    }
    @GetMapping("/secure/admin/GetAllAccountBlocked")
    public Optional<List<Accounts>> endPoint(){
    return this.accountsService.getAllAccountsBlokced();
    }
    @PutMapping("/secure/admin/AllowAdminToNavigate/{id}")
    public void endPoint(@PathVariable Long id){
        System.out.println(id);
        this.accountsService.UpdateAccountBlockedToAllowWorkenAsAnAdmin(id);
    }

    /*@PostMapping("/CreateAccount")
    public Accounts createAccount(@RequestBody Accounts account) {

        System.out.println("update client is made succefully");
        return accountsService.createAccount(account);
    }*/
/*to chnge to make the update with the username*/
    @PutMapping("/common/UpdateAccount/{id}")
    public Accounts updateAccount(@PathVariable Long id, @RequestBody Accounts updatedContrat) {
        return accountsService.updateAccount(id, updatedContrat);
    }

    @DeleteMapping("/secure/admin/DeleteAccount/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountsService.deleteAccount(id);
    }

}
