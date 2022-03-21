package repository;

import curent.domain.Student;
import validation.*;

public class StudentRepository extends AbstractCrudRepository<Long, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}
