package com.example.demo.DbInitializr;

import com.example.demo.Accounts.Accounts;
import com.example.demo.Accounts.AccountsRepo;
import com.example.demo.Accounts.roleEnum.Rola;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitializrService {

    private static  PasswordEncoder passwordEncoder;


    private static AccountsRepo accRepo = null;
    @Autowired
    public InitializrService(PasswordEncoder passwordEncoder, AccountsRepo a){
        this.passwordEncoder = passwordEncoder;
        this.accRepo=a;
    }
    public static void createTheFirstAdmin(){
         String adminName="Amin";

        /*@Value("${password}")*/
        String password="AminRoot";
        String email="AminRootLocation@gmail.com";
        Accounts acc=new Accounts(
                0l,
                adminName,
                email,
                passwordEncoder.encode(password),
                Rola.ADMIN,
                Boolean.TRUE);

    try{
        Accounts accCreated=accRepo.save(acc);
        System.out.println("the Admin account is created");
        System.out.println("The AdminName : "+accCreated.getUsername());
        System.out.println("the password :"+password);
        System.out.println("use this account to logIn");


    }catch (Exception e){
    System.out.println("We got an error to create the admin account please try this process again");
    System.out.println("Or check the database");

    }
    }
    }
