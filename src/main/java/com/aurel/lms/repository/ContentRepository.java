package com.aurel.lms.repository;

import com.aurel.lms.model.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends CrudRepository<Content, Integer> {
}
