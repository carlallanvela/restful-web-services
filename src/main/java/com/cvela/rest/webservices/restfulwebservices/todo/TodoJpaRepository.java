package com.cvela.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Todo JPA Repository.
 * @author Carl Allan Vela
 *
 */
@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
	List<Todo> findByUsername(String username);
}
