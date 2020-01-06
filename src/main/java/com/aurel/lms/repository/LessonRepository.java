package com.aurel.lms.repository;

import com.aurel.lms.model.lesson.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
