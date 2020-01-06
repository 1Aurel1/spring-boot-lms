package com.aurel.lms.repository;

import com.aurel.lms.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TermRepository extends JpaRepository<Term, Integer> {

    Optional<Term> getById(int id);
}
