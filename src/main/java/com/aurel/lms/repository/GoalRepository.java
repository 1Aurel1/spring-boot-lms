package com.aurel.lms.repository;

import com.aurel.lms.model.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepository extends CrudRepository<Goal, Integer> {
}
