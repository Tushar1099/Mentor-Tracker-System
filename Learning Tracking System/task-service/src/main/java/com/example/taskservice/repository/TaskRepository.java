package com.example.taskservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskservice.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByTaskId(int taskId);

	List<Task> findByUserId(int taskId);

	

}
