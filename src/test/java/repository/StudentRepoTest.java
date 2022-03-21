package repository;

import curent.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentRepoTest {
    StudentRepository studentRepository;
    Validator<Student> validator=new StudentValidator();
    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository(validator);    }


//at home
@Test
@DisplayName("Adding a valid student name")
void testAddStudent_validName(){
    this.studentRepository.save(new Student(1000L, "student1", 931, "stud@yahoo.com", "hehe"));
    Student student = this.studentRepository.findOne(1000L);
    assertEquals(student.getNume(), "student1");

}
    @Test
    @DisplayName("Adding a invalid student name")
    void testAddStudent_invalidName(){
        this.studentRepository.save(new Student(100L, "", 931, "stud@yahoo.com", "hehe"));
        Student student = this.studentRepository.findOne(100L);
        assertEquals(student,null);

    }

    @Test
    @DisplayName("Adding a invalid student group")
    void testAddStudent_invalidGroup(){
        this.studentRepository.save(new Student(10L, "ll", -1, "stud@yahoo.com", "hehe"));
        Student student = this.studentRepository.findOne(10L);
        assertEquals(student,null);

    }
    @Test
    @DisplayName("Adding a valid student group")
    void testAddStudent_validGroup(){
        this.studentRepository.save(new Student(100L, "student", 932, "stud@yahoo.com", "hehe"));
        Student student = this.studentRepository.findOne(100L);
        assertEquals(student.getGrupa(),932);

    }

    @Test
    @DisplayName("Adding a valid mail")
    void testAddStudent_validMail(){
        this.studentRepository.save(new Student(10L, "student", 932, "stud@yahoo.com", "hehe"));
        Student student = this.studentRepository.findOne(10L);
        assertEquals(student.getEmail(),"stud@yahoo.com");


    }
    @Test
    @DisplayName("Adding an invalid mail")
    void testAddStudent_invalidMail(){
        this.studentRepository.save(new Student(11L, "student", 932, "", "hehe"));
        Student student = this.studentRepository.findOne(11L);
        assertEquals(student,null);


    }
    @Test
    @DisplayName("Adding an invalid professor")
    void testAddStudent_invalidProfessor(){
        this.studentRepository.save(new Student(12L, "student", 932, "", ""));
        Student student = this.studentRepository.findOne(12L);
        assertEquals(student,null);


    }
    @Test
    @DisplayName("Adding a valid professor")
    void testAddStudent_validProfessor(){
        this.studentRepository.save(new Student(12L, "student", 932, "stud@ubb.com", "hehe"));
        Student student = this.studentRepository.findOne(12L);
        assertEquals(student.getNumeProfesor(),"hehe");


    }

}
