package com.spring.faltdor.api.demoapijwt.repository;

import com.spring.faltdor.api.demoapijwt.data.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Long, Task> {
}
