package com.aurel.lms.repository;

import com.aurel.lms.model.authority.Authority;
import com.aurel.lms.model.authority.AuthorityName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Optional<Authority> findByName(AuthorityName name);
}
