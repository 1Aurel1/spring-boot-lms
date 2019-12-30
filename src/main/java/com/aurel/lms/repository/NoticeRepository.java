package com.aurel.lms.repository;

import com.aurel.lms.model.Notice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Integer> {
}
