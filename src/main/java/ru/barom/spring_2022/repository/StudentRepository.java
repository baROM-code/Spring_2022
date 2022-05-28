package ru.barom.spring_2022.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.barom.spring_2022.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
