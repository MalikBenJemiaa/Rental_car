package com.example.demo.LogInRegisterRouters.AuthenticationSchemas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AthenticationRequest {
    private String  username;
    private String email;


    private String  password;

}
