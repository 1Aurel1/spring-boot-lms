package com.aurel.lms.repository;

import com.aurel.lms.model.Term;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends CrudRepository<Term, Integer> {
}
