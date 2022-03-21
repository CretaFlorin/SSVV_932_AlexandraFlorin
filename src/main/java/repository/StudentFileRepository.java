package repository;

import curent.domain.Student;
import validation.Validator;

public class StudentFileRepository extends AbstractFileRepository<Long, Student> {

    /**
     * Class constructor
     * @param filename - numele fisierului
     */
    public StudentFileRepository(Validator<Student> validator,String filename) {
        super(validator,filename);
    }

    /**
     * Extrage informatia despre student dintr-un string
     * @param linie - stringul din care ia datele studentului
     * @return studentul
     */
    @Override
    public Student extractEntity(String linie) {
        String[] cuvinte = linie.split(",");
        return new Student(Long.parseLong(cuvinte[0]), cuvinte[1], Integer.parseInt(cuvinte[2]), cuvinte[3], cuvinte[4]);
    }
}
