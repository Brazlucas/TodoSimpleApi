package com.lucasbraz.todosimple.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucasbraz.todosimple.models.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

 //  Primeira convenção:
 //  List<Task> findByUser_Id(Long id);

 // Segundo jeito de fazer a query
 // @Query(value = "SELECT t FROM Task t WHERE t.user.id = :user_id")
 // List<Task> xyz(@Param("user_id") Long user_id);

 // query pura, sem SpringBoot
 @Query(value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery = true)
 List<Task> findByUser_Id(@Param("id") Long id);
}
