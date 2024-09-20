/*************  ✨ Codeium Command 🌟  *************/
package com.livecode.livecode_loan_app.model;

import static com.livecode.livecode_loan_app.model.Permission.*;

// import java.security.Permission;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    STAFF(
            Set.of(
                    STAFF_CREATE,
                    STAFF_READ,
                    STAFF_DELETE,
                    STAFF_UPDATE)),
    ADMIN(
            Set.of(
                    ADMIN_CREATE,
                    ADMIN_READ,
                    ADMIN_DELETE,
                    ADMIN_UPDATE,
                    STAFF_CREATE,
                    STAFF_READ,
                    STAFF_DELETE,
                    STAFF_UPDATE,
                    CUSTOMER_CREATE,
                    CUSTOMER_READ,
                    CUSTOMER_DELETE,
                    CUSTOMER_UPDATE)),
    CUSTOMER(
            Set.of(
                    CUSTOMER_CREATE,
                    CUSTOMER_READ,
                    CUSTOMER_DELETE,
                    CUSTOMER_UPDATE));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}

/****** 8680c64c-9b2f-4963-a454-26da99c779f4 *******/