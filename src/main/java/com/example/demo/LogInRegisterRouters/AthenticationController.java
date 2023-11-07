package com.example.demo.LogInRegisterRouters;


import com.example.demo.LogInRegisterRouters.AuthenticationSchemas.AthenticationRequest;
import com.example.demo.LogInRegisterRouters.AuthenticationSchemas.AuthenticationResponse;
import com.example.demo.LogInRegisterRouters.AuthenticationSchemas.LoginRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Athentication")
/*@RequiredArgsConstructor*/
/*@NoArgsConstructor*/
public class AthenticationController {
    private final AuthenticationService authenticationService;

@Autowired
    public AthenticationController(AuthenticationService authenticationService) {
    this.authenticationService=authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AthenticationRequest req
            ){
            return ResponseEntity.ok(authenticationService.register(req));

    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody LoginRequest req
    ){
        return ResponseEntity.ok(authenticationService.authenticate(req));

    }
}
