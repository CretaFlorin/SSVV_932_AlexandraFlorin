package repository;
import curent.domain.Student;
import curent.domain.Tema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TemaRepoTest {
    TemaRepository temaRepository;
    Validator<Tema> validator=new TemaValidator();
    @BeforeEach
    void setUp() {
        temaRepository = new TemaRepository(validator);    }

    @Test
    @DisplayName("Test case for invalid description")
    void testAddAssignment_invalidDescription(){
        this.temaRepository.save(new Tema(100L,"",3,2));
        Tema t = this.temaRepository.findOne(100L);
        Assertions.assertNull(t);
    }

    @Test
    @DisplayName("Test case for valid description")
    void testAddAssignment_validDescription(){
        this.temaRepository.save(new Tema(100L,"blabla",3,2));
        Tema t = this.temaRepository.findOne(100L);
        Assertions.assertEquals(t.getDescriere(),"blabla");
    }

    @Test
    @DisplayName("Test case valid deadline")
    void testAddAssignment_validDeadline(){
        this.temaRepository.save(new Tema(10L,"bla",4,2));
        Tema t = this.temaRepository.findOne(10L);
        Assertions.assertEquals(t.getDeadline(),4);
    }

    @Test
    @DisplayName("Test case invalid deadline lower bound")
    void testAddAssignment_invalidDeadlineLow(){
        this.temaRepository.save(new Tema(11L,"bla",0,2));
        Tema t = this.temaRepository.findOne(11L);
        Assertions.assertNull(t);
    }

    @Test
    @DisplayName("Test case invalid deadline upper bound")
    void testAddAssignment_invalidDeadlineUp(){
        this.temaRepository.save(new Tema(11L,"bla",15,2));
        Tema t = this.temaRepository.findOne(11L);
        Assertions.assertNull(t);
    }

    @Test
    @DisplayName("Test case valid primire")
    void testAddAssignment_validPrimire(){
        this.temaRepository.save(new Tema(11L,"bla",4,2));
        Tema t = this.temaRepository.findOne(11L);
        Assertions.assertEquals(t.getPrimire(),2);
    }

    @Test
    @DisplayName("Test case invalid primire lower bound")
    void testAddAssignment_invalidPrimireLow(){
        this.temaRepository.save(new Tema(1L,"bla",4,0));
        Tema t = this.temaRepository.findOne(1L);
        Assertions.assertNull(t);
    }

    @Test
    @DisplayName("Test case invalid primire upper bound")
    void testAddAssignment_invalidPrimireUp(){
        this.temaRepository.save(new Tema(1L,"bla",13,15));
        Tema t = this.temaRepository.findOne(1L);
        Assertions.assertNull(t);
    }

}
