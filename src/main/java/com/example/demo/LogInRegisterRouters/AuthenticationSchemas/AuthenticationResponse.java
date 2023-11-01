package com.example.demo.LogInRegisterRouters.AuthenticationSchemas;

import com.example.demo.Accounts.roleEnum.Rola;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String username;
    private Rola role;
    private String msg;
}
