package com.example.demo.Accounts;

import com.example.demo.Accounts.roleEnum.Rola;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Data
@Builder
/*@NoArgsConstructor*/
@AllArgsConstructor
@Entity
@Table
public class Accounts implements UserDetails {
    @Id
    @SequenceGenerator(
            name="Accounts_sequence",
            sequenceName = "Accounts_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Accounts_sequence"
    )
    private long id;
    @Column(unique = true, nullable = false) // Make the username field both unique and not null
    @NotNull
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Make the role field not null
    @NotNull
    private Rola role;
    private Boolean worken;
    public Accounts() {
    }
    public Accounts(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
