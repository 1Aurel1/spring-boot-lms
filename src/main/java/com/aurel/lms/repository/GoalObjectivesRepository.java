package com.aurel.lms.repository;

import com.aurel.lms.model.GoalObjectives;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalObjectivesRepository extends CrudRepository<GoalObjectives, Integer> {
}
