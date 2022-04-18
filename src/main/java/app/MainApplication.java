package app;


import repository.*;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import view.UI;



public class MainApplication {

    public static void main(String[] args) {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();

        String filenameStudent = "src\\main\\fisiere\\Studenti.xml";
        String filenameTema = "src\\main\\fisiere\\Teme.xml";
        String filenameNota = "src\\main\\fisiere\\Catalog.xml";

       //StudentFileRepository studentFileRepository = new StudentFileRepository(filenameStudent);
        //TemaFileRepository temaFileRepository = new TemaFileRepository(filenameTema);
        //NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepository);
        //NotaFileRepository notaFileRepository = new NotaFileRepository(filenameNota);

        //StudentXMLRepo studentXMLRepository = new StudentXMLRepo(studentValidator,filenameStudent);
        //TemaXMLRepo temaXMLRepository = new TemaXMLRepo(temaValidator,filenameTema);
        StudentRepository studentRepository=new StudentRepository(studentValidator);
        TemaRepository temaRepository=new TemaRepository(temaValidator);
        NotaValidator notaValidator = new NotaValidator(studentRepository, temaRepository);
        NotaRepository notaRepository = new NotaRepository(notaValidator);
        Service service = new Service(studentRepository, studentValidator, temaRepository, temaValidator, notaRepository, notaValidator);
        UI ui = new UI(service);
        ui.run();
    }

}
