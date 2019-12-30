package com.aurel.lms.repository;

import com.aurel.lms.model.Goal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends CrudRepository<Goal, Integer> {
}
