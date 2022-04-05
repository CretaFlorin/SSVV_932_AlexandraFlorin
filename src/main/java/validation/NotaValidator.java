package validation;


import curent.domain.Nota;
import curent.domain.Student;
import curent.domain.Tema;
import repository.*;

public class NotaValidator implements Validator<Nota> {
   // private StudentXMLRepo studentFileRepository;
    //private TemaXMLRepo temaFileRepository;
private StudentRepository studentRepository;
private TemaRepository temaRepository;
    /**
     * Class constructor
     * @param studRepository - repository student
     * @param temRepository - repository tema
     */
    public NotaValidator(StudentRepository studRepository, TemaRepository temRepository) {
        this.studentRepository = studRepository;
        this.temaRepository = temRepository;
    }

    /**
     * Valideaza o nota
     * @param nota - nota pe care o valideaza
     * @throws ValidationException daca nota nu e valida
     */
    @Override
    public void validate(Nota nota) throws ValidationException {
        Student student = studentRepository.findOne(nota.getIdStudent());
        if (student== null){
            throw new ValidationException("Studentul nu exista!");
        }
        Tema tema = temaRepository.findOne(nota.getIdTema());
        if(tema == null){
            throw new ValidationException("Tema nu exista!");
        }
        double notaC = nota.getNota();
        if(notaC > 10.00 || notaC < 0.00){
            throw new ValidationException("Valoarea notei nu este corecta!");
        }
    }
}
