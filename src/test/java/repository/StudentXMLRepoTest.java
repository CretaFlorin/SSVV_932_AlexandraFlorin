package repository;

import curent.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentXMLRepoTest {
    StudentXMLRepo studentXMLRepo;
Validator<Student> validator=new StudentValidator();
    @BeforeEach
    void setUp() {
       studentXMLRepo = new StudentXMLRepo(validator,"C:\\Users\\alexa\\IdeaProjects\\lab2ssvv\\SSVV\\src\\test\\fisiere\\Studenti.xml");
   }
//tests from in class
    @Test
    @DisplayName("Adding a valid student")
    void testAddStudent_valid() {
        this.studentXMLRepo.save(new Student(1000L, "student1", 931, "stud@yahoo.com", "hehe"));
        Student student = this.studentXMLRepo.findOne(1000L);
        assertEquals(student.getNume(), "student1");
        assertEquals(student.getEmail(), "stud@yahoo.com");
       assertEquals(student.getGrupa(), 931);
        assertEquals(student.getNumeProfesor(), "hehe");

       this.studentXMLRepo.delete(1000L);
    }
//adding an invalid student meaning the id already exists so the student should not be modified
    @Test
    @DisplayName("Adding an invalid student")
    void testAddStudent_invalid() {
        this.studentXMLRepo.save(new Student(1000L, "student1", 931, "stud@yahoo.com", "hehe"));
        this.studentXMLRepo.save(new Student(1000L, "student2", 932, "stud2@yahoo.com", "hehe2"));
        Student student = this.studentXMLRepo.findOne(1000L);
        assertEquals(student.getNume(), "student1");
        assertEquals(student.getEmail(), "stud@yahoo.com");
       assertEquals(student.getGrupa(), 931);
        assertEquals(student.getNumeProfesor(), "hehe");

       this.studentXMLRepo.delete(1000L);
   }


}
