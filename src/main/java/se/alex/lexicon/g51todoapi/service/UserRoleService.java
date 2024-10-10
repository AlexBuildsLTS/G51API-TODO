package se.alex.lexicon.g51todoapi.service;

import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOView;
import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOForm;

import java.util.List;

public interface UserRoleService {

    List<RoleDTOView> getAllRoles();

    RoleDTOView findRoleById(Long id);

    RoleDTOView createRole(RoleDTOForm form);

    RoleDTOView updateRole(Long id, RoleDTOForm form);

    void deleteRole(Long id);

    default List < RoleDTOView > getAll ( ) {
        return null;
    }
}
