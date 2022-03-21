package app;


import repository.NotaFileRepository;
import repository.StudentFileRepository;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import repository.NotaXMLRepo;
import repository.TemaFileRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import view.UI;



public class MainApplication {

    public static void main(String[] args) {
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "C:\\Users\\creta\\Desktop\\ssvv\\Lab_Project\\src\\main\\fisiere\\Studenti.xml";
        String filenameTema = "C:\\Users\\creta\\Desktop\\ssvv\\Lab_Project\\src\\main\\fisiere\\Teme.xml";
        String filenameNota = "C:\\Users\\creta\\Desktop\\ssvv\\Lab_Project\\src\\main\\fisiere\\Catalog.xml";

       //StudentFileRepository studentFileRepository = new StudentFileRepository(filenameStudent);
        //TemaFileRepository temaFileRepository = new TemaFileRepository(filenameTema);
        //NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepository);
        //NotaFileRepository notaFileRepository = new NotaFileRepository(filenameNota);

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        UI ui = new UI(service);
        ui.run();
    }

}