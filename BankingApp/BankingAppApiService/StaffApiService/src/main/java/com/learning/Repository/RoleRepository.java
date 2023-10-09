package com.learning.Repository;


import com.learning.Entity.model.Role;
import com.learning.common.constants.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(Roles name);
}
