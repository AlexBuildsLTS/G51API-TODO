package se.alex.lexicon.g51todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.alex.lexicon.g51todoapi.converter.RoleConverter;
import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOView;
import se.alex.lexicon.g51todoapi.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
                                                    public class RoleServiceImpl {

    private final RoleRepository roleRepository;
    private final RoleConverter roleConverter;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleConverter roleConverter) {
        this.roleRepository = roleRepository;
        this.roleConverter = roleConverter;
    }

    public List<RoleDTOView> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleConverter::toRoleDTOView)
                .collect(Collectors.toList());
    }
}
