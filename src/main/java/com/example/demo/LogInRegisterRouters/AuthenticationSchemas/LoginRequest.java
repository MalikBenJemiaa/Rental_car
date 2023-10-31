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
public class LoginRequest {
    private String  username;

    private String  password;
}
