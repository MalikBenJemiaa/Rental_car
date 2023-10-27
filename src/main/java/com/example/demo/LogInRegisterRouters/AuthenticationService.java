package com.example.demo.LogInRegisterRouters;

import com.example.demo.Accounts.Accounts;
import com.example.demo.Accounts.AccountsRepo;
import com.example.demo.Accounts.roleEnum.Rola;
import com.example.demo.LogInRegisterRouters.AuthenticationSchemas.AthenticationRequest;
import com.example.demo.LogInRegisterRouters.AuthenticationSchemas.AuthenticationResponse;
import com.example.demo.config.jwtServices.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AccountsRepo accountsRepo;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(AthenticationRequest req) {

            var user = Accounts.builder()
                    .username(req.getUsername())
                    .password(passwordEncoder.encode(req.getPassword()))
                    .email(req.getEmail())
                    .role(Rola.ADMIN)
                    .build();
            accountsRepo.save(user);
            var jwtToken=jwtService.generateToken(user);
            return new AuthenticationResponse().builder().token(jwtToken).build();



    }

    public AuthenticationResponse authenticate(AthenticationRequest req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(),
                        req.getPassword()
                )

        );

        var user=accountsRepo.findAccountsByUsername(req.getUsername())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        return new AuthenticationResponse().builder().token(jwtToken).build();

    }
}
