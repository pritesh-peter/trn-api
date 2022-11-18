package com.trn.core.api.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trn.core.api.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters")
    private String name;

    @Email(message ="Email address in invalid")
    private String email;

    @NotEmpty
    @Size(min = 4,max=10,message = "Password must be min 4 and max 10")
    private String password;

    @NotEmpty
    @Size(min = 5, message = "About must be min 5 characters")
    private String about;

    private Set<RoleDto> roles = new HashSet<>();

    @JsonIgnore
    public String getPassword() {
        return password;
    }
}
