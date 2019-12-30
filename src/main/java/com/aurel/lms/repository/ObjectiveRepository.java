package com.aurel.lms.repository;

import com.aurel.lms.model.Objective;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends CrudRepository<Objective, Integer> {
}
