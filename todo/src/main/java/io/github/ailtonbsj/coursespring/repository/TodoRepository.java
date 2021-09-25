package io.github.ailtonbsj.coursespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.ailtonbsj.coursespring.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
