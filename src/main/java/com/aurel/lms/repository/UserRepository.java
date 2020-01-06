package com.aurel.lms.repository;

import com.aurel.lms.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    Optional<User> getById(int id);

    User findByAccountNonExpired(boolean b);
}
