//package repository;
//
//import curent.domain.Student;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class StudentXMLRepoTest {
//    StudentXMLRepo studentXMLRepo;
//
//    @BeforeEach
//    void setUp() {
//        studentXMLRepo = new StudentXMLRepo("C:\\Users\\creta\\Desktop\\ssvv\\Lab_Project\\src\\test\\fisiere\\Studenti.xml");
//    }
//
//    @Test
//    @DisplayName("Adding a valid student")
//    void testAddStudent_valid() {
//        this.studentXMLRepo.save(new Student("1000", "student1", 931, "stud@yahoo.com", "hehe"));
//        Student student = this.studentXMLRepo.findOne("1000");
//        assertEquals(student.getNume(), "student1");
//        assertEquals(student.getEmail(), "stud@yahoo.com");
//        assertEquals(student.getGrupa(), 931);
//        assertEquals(student.getNumeProfesor(), "hehe");
//
//        this.studentXMLRepo.delete("1000");
//    }
//
//    @Test
//    @DisplayName("Adding a valid student")
//    void testAddStudent_invalid() {
//        this.studentXMLRepo.save(new Student("1000", "student1", 931, "stud@yahoo.com", "hehe"));
//        this.studentXMLRepo.save(new Student("1000", "student2", 932, "stud2@yahoo.com", "hehe2"));
//        Student student = this.studentXMLRepo.findOne("1000");
//        assertEquals(student.getNume(), "student1");
//        assertEquals(student.getEmail(), "stud@yahoo.com");
//        assertEquals(student.getGrupa(), 931);
//        assertEquals(student.getNumeProfesor(), "hehe");
//
//        this.studentXMLRepo.delete("1000");
//    }
//
//}
