package com.tclab.restfulwebservice.repo;

import com.tclab.restfulwebservice.ent.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {

  List<Todo> findByUsername(String username);
}
