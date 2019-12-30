package com.aurel.lms.repository;

import com.aurel.lms.model.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
}
