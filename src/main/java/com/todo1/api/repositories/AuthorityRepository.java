package com.todo1.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.api.entities.Authority;

@Repository("roleRepository")
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
