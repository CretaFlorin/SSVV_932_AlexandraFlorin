package service;

import curent.Curent;
import curent.domain.Nota;
import curent.domain.Student;
import curent.domain.Tema;

import repository.*;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Clasa Service
 */
public class Service {
    private StudentRepository studentRepository;
    //private StudentFileRepository studentFileRepository;
  //  private StudentXMLRepo studentFileRepository;
    private StudentValidator studentValidator;
    //private TemaFileRepository temaFileRepository;
    private TemaRepository temaRepository;
   // private TemaXMLRepo temaFileRepository;
    private TemaValidator temaValidator;
    //private NotaFileRepository notaFileRepository;
    //private NotaXMLRepo notaFileRepository;
    private NotaRepository notaRepository;
    private NotaValidator notaValidator;

    /**
     * Class Constructor
     *
     * @param studentFileRepository - repository student
     * @param studentValidator      - validator student
     * @param temaFileRepository    - repository tema
     * @param temaValidator         - validator tema
     * @param notaFileRepository    - repository nota
     * @param notaValidator         - validator nota
     */
    //public Service(StudentFileRepository studentFileRepository, StudentValidator studentValidator, TemaFileRepository temaFileRepository, TemaValidator temaValidator, NotaFileRepository notaFileRepository, NotaValidator notaValidator) {
    public Service(StudentRepository studentFileRepository, StudentValidator studentValidator, TemaRepository temaFileRepository, TemaValidator temaValidator, NotaRepository notaFileRepository, NotaValidator notaValidator) {

        this.studentRepository = studentFileRepository;
        this.studentValidator = studentValidator;
        this.temaRepository = temaFileRepository;
        this.temaValidator = temaValidator;
        this.notaRepository = notaFileRepository;
        this.notaValidator = notaValidator;
    }

    /**
     * adauga un Student in memorie
     *
     * @param student - studentul pe care il adauga
     * @return null daca studentul a fost adaugat cu succes sau studentul din memorie daca acesta exista deja
     */
    public Student addStudent(Student student) {
        studentValidator.validate(student);
        return studentRepository.save(student);
    }

    /**
     * Sterge un student
     *
     * @param id - id-ul studentului
     * @return studentul daca acesta a fost sters sau null daca studentul nu exista
     */
    public Student deleteStudent(Long id) {
        if (id == null || id.equals(0L)) {
            throw new ValidationException("Id-ul nu poate fi null!");
        }
        return studentRepository.delete(id);
    }

    /**
     * Cauta un student dupa id
     *
     * @param id - id-ul studentului
     * @return studentul daca acesta exista sau null altfel
     */
    public Student findStudent(Long id) {
        if (id == null || id.equals(0L)) {
            throw new ValidationException("Id-ul nu poate fi null!");
        }
        return studentRepository.findOne(id);
    }

    /**
     * Modifica un student
     *
     * @param student - noul student
     * @return noul student daca s-a facut modificarea sau null daca acesta nu exista
     */
    public Student updateStudent(Student student) {
        studentValidator.validate(student);
        return studentRepository.update(student);
    }

    /**
     * @return toti studentii din memorie
     */
    public Iterable<Student> getAllStudenti() {
        return studentRepository.findAll();
    }

    /**
     * Adauga o tema noua
     *
     * @param tema - tema pe care o adauga
     * @return null daca s-a facut adaugarea sau tema daca aceasta exista deja
     */
    public Tema addTema(Tema tema) {
        temaValidator.validate(tema);
        return temaRepository.save(tema);
    }

    /**
     * Sterge o tema
     *
     * @param nrTema - nr-ul temei
     * @return tema daca aceasta a fost stearsa sau null daca tema nu exista
     */
    public Tema deleteTema(Long nrTema) {
        if (nrTema == null || nrTema.equals(0L)) {
            throw new ValidationException("Id-ul nu poate fi null!");
        }
        return temaRepository.delete(nrTema);
    }

    /**
     * Cauta o tema
     *
     * @param id - id-ul temei
     * @return tema sau null daca aceasta nu exista
     */
    public Tema findTema(Long id) {
        if (id == null || id.equals(0L)) {
            throw new ValidationException("Id-ul nu poate fi null!");
        }
        return temaRepository.findOne(id);
    }

    /**
     * Modifica o tema
     *
     * @param tema - noua tema
     * @return tema daca s-a facut modificarea sau null daca acesta nu exisra
     */
    public Tema updateTema(Tema tema) {
        temaValidator.validate(tema);
        return temaRepository.update(tema);
    }

    /**
     * @return toate temele din memorie
     */
    public Iterable<Tema> getAllTeme() {
        return temaRepository.findAll();
    }

    /**
     * Adauga o nota
     *
     * @param nota     - nota
     * @param feedback - feedback-ul notei
     * @return null daca nota a fost adaugata sau nota daca aceasta exista deja
     */
    public double addNota(Nota nota, String feedback) {
        notaValidator.validate(nota);
        Student student = studentRepository.findOne(nota.getIdStudent());
        Tema tema = temaRepository.findOne(nota.getIdTema());
        int predare = calculeazaSPredare(nota.getData());
//        System.out.println(predare);
//        System.out.println(tema.getDeadline());
        if (predare != tema.getDeadline()) {
            if (predare - tema.getDeadline() == 1) {
                nota.setNota(nota.getNota() - 2.5);
            } else {
                throw new ValidationException("Studentul nu mai poate preda aceasta tema!");
            }
        }
        notaRepository.save(nota);
        String filename = "src\\main\\fisiere\\" + student.getNume() + ".txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {
            bufferedWriter.write("\nTema: " + tema.getId());
            bufferedWriter.write("\nNota: " + nota.getNota());
            bufferedWriter.write("\nPredata in saptamana: " + predare);
            bufferedWriter.write("\nDeadline: " + tema.getDeadline());
            bufferedWriter.write("\nFeedback: " + feedback);
            bufferedWriter.newLine();
        } catch (IOException exception) {
            throw new ValidationException(exception.getMessage());
        }
        return nota.getNota();
    }

    /**
     * Sterge o nota
     *
     * @param id - id-ul notei
     * @return nota daca aceasta a fost stearsa sau null daca nota nu exista
     */
    public Nota deleteNota(Long id) {
        if (id == null || id.equals(0L)) {
            throw new ValidationException("Id-ul nu poate fi null!");
        }
        return notaRepository.delete(id);
    }

    /**
     * Cauta o nota
     *
     * @param id - id-ul notei
     * @return nota sau null daca aceasta nu exista
     */
    public Nota findNota(Long id) {
        if (id == null || id.equals(0L)) {
            throw new ValidationException("Id-ul nu poate fi null!");
        }
        return notaRepository.findOne(id);
    }

    /**
     * @return toate notele
     */
    public Iterable<Nota> getAllNote() {
        return notaRepository.findAll();
    }

    /**
     * Prelungeste deadline-ul unei teme
     *
     * @param nrTema   - nr-ul temei
     * @param deadline - noul deadline
     */
    public void prelungireDeadline(Long nrTema, int deadline) {
        int diff = Curent.getCurrentWeek();
        Tema tema = temaRepository.findOne(nrTema);
        if (tema == null) {
            throw new ValidationException("Tema inexistenta!");
        }
        if (tema.getDeadline() >= diff) {
            tema.setDeadline(deadline);
            //temaRepository.writeToFile();
        } else {
            throw new ValidationException("Nu se mai poate prelungi deadline-ul!");
        }
    }

    /**
     * Calculeaza saptamana de predare
     *
     * @param predare - data predarii unei teme
     * @return saptamana in care a fost predata tema
     */
    private int calculeazaSPredare(LocalDate predare) {
        LocalDate startDate = Curent.getStartDate();
        long days = DAYS.between(startDate, predare);
        double saptamanaPredare = Math.ceil((double) days / 7);
        return (int) saptamanaPredare;
    }
}
