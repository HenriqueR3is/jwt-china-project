package br.com.faculdade.jwt_china_project.dto;

import br.com.faculdade.jwt_china_project.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String name;
    private String email;
    private String password;
    private Role role;
}