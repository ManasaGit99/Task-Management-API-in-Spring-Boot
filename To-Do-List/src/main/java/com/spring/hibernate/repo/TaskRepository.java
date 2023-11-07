package com.spring.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.hibernate.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
