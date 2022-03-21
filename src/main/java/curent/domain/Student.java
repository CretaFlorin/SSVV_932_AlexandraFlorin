package curent.domain;

public class Student extends BaseEntity<Long> {
    private String nume;
    private int grupa;
    private String email;
    private String numeProfesor;

    /**
     * Class Constructor
     *
     * @param idStudent    - id-ul studentului
     * @param nume         - numele studentului
     * @param grupa        - grupa studentului
     * @param email        - emailul unui student
     * @param numeProfesor - numele profesorului studentului
     */
    public Student(Long idStudent, String nume, int grupa, String email, String numeProfesor) {
        this.setId(idStudent);
        this.nume = nume;
        this.grupa = grupa;
        this.email = email;
        this.numeProfesor = numeProfesor;
    }



    /**
     * @return numele studentului
     */
    public String getNume() {
        return nume;
    }

    /**
     * modifica numele studentului
     *
     * @param nume - noul nume
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * @return grupa studentului
     */
    public int getGrupa() {
        return grupa;
    }

    /**
     * modifica grupa studentului
     *
     * @param grupa - noua grupa
     */
    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    /**
     * @return emai-ul studentului
     */
    public String getEmail() {
        return email;
    }

    /**
     * modifica emailul studentului
     *
     * @param email - noul email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return numele profesorului studentului
     */
    public String getNumeProfesor() {
        return numeProfesor;
    }

    /**
     * modifica numele profesorului studentului
     *
     * @param numeProfesor - noul nume al profesorului
     */
    public void setNumeProfesor(String numeProfesor) {
        this.numeProfesor = numeProfesor;
    }



    /**
     * @return un obiect de tip Student sub forma de string
     */
    @Override
    public String toString() {
        return "Student{" +
                "idStudent='" + this.getId() + '\'' +
                ", nume='" + nume + '\'' +
                ", grupa=" + grupa +
                ", email='" + email + '\'' +
                ", numeProfesor='" + numeProfesor + '\'' +
                '}';
    }
}
