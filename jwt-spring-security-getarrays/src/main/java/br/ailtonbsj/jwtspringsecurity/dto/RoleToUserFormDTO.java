package br.ailtonbsj.jwtspringsecurity.dto;

import lombok.Data;

@Data
public class RoleToUserFormDTO {
    private String username;
    private String roleName;
}
