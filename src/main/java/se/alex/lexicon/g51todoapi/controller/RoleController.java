package se.alex.lexicon.g51todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOView;
import se.alex.lexicon.g51todoapi.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public RoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public ResponseEntity<RoleDTOView> createRole(@RequestBody RoleDTOForm roleDTOForm) {
        RoleDTOView createdRole = userRoleService.createRole(roleDTOForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @GetMapping
    public ResponseEntity<List<RoleDTOView>> getAllRoles() {
        List<RoleDTOView> roles = userRoleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTOView> getRoleById(@PathVariable Long id) {
        RoleDTOView role = userRoleService.findRoleById(id);
        return ResponseEntity.ok(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTOView> updateRole(@PathVariable Long id, @RequestBody RoleDTOForm roleDTOForm) {
        RoleDTOView updatedRole = userRoleService.updateRole(id, roleDTOForm);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        userRoleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}