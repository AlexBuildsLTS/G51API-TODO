package se.alex.lexicon.g51todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOView;
import se.alex.lexicon.g51todoapi.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final UserRoleService roleService;

    @Autowired
    public RoleController( UserRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public HttpEntity<Object> getAllRoles() {
        List<RoleDTOView> roles = roleService.getAll();
        return ResponseEntity.ok(roles);
    }
}
