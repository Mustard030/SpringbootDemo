package org.example.springbootstudy.DAO;

import org.example.springbootstudy.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> , QueryByExampleExecutor<Student> {
    List<Student> findByName(String name);
}
