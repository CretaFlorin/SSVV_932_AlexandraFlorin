package repository;

import curent.domain.Nota;
import curent.domain.Student;
import curent.domain.Tema;
import org.junit.Before;
import org.junit.jupiter.api.*;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AllRepoTest {
    StudentRepository studentRepository;
    Validator<Student> validator=new StudentValidator();
    TemaRepository temaRepository;
    Validator<Tema> validatorTema=new TemaValidator();
    NotaRepository notaRepository;
    Validator<Nota> notaValidator;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository(validator);
    temaRepository=new TemaRepository(validatorTema);
    notaValidator=new NotaValidator(studentRepository,temaRepository);
    notaRepository=new NotaRepository(notaValidator);
    }
    @Test
    @DisplayName("Adding a valid student name")
    void testAddStudent_validName() {
        this.studentRepository.save(new Student(1000L, "student1", 931, "stud@yahoo.com", "hehe"));
        Student student = this.studentRepository.findOne(1000L);
        assertEquals(student.getNume(), "student1");
    }

    @Test
    @DisplayName("Test case for valid description")
    void testAddAssignment_validDescription(){
        this.temaRepository.save(new Tema(100L,"blabla",3,2));
        Tema t = this.temaRepository.findOne(100L);
        Assertions.assertEquals(t.getDescriere(),"blabla");
    }
    @Test
    @DisplayName("Test case for valid grade")
    void testAddGrade_valid(){
        this.studentRepository.save(new Student(1000L, "student1", 931, "stud@yahoo.com", "hehe"));
        this.temaRepository.save(new Tema(100L,"blabla",3,2));
        this.notaRepository.save(new Nota(1L,1000L,100L,8, LocalDate.now()));
        Nota n = this.notaRepository.findOne(1L);
        Assertions.assertEquals(n.getNota(),8);
    }
@Test
    @DisplayName("Integration")
    void testAll(){

    this.studentRepository.save(new Student(1000L, "student1", 931, "stud@yahoo.com", "hehe"));
    this.temaRepository.save(new Tema(100L,"blabla",3,2));
    this.notaRepository.save(new Nota(1L,1000L,100L,8, LocalDate.now()));
    Nota n = this.notaRepository.findOne(1L);
    Assertions.assertEquals(n.getNota(),8);
    Tema t = this.temaRepository.findOne(100L);
    Assertions.assertEquals(t.getDescriere(),"blabla");
    Student student = this.studentRepository.findOne(1000L);
    assertEquals(student.getNume(), "student1");
/*testAddAssignment_validDescription();
testAddStudent_validName();
testAddGrade_valid();*/
}

    }
