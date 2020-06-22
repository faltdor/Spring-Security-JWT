package com.spring.faltdor.api.demoapijwt.repository;

import com.spring.faltdor.api.demoapijwt.data.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
