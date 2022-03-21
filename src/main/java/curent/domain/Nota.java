package curent.domain;

import java.time.LocalDate;

public class Nota extends BaseEntity<Long> {
    private Long idStudent;
    private Long idTema;
    private double nota;
    private final LocalDate data;

    /**
     * Class Constructor
     *
     * @param id        - id-ul notei
     * @param idStudent - id-ul studentului
     * @param idTema    - id-ul temei
     * @param nota      - valoarea notei
     * @param data      - data in care a fost predata tema
     */
    public Nota(Long id, Long idStudent, Long idTema, double nota, LocalDate data) {
        this.setId(id);
        this.idStudent = idStudent;
        this.idTema = idTema;
        this.nota = nota;
        this.data = data;
    }

    /**
     * @return id-ul studentului
     */
    public Long getIdStudent() {
        return this.idStudent;
    }

    /**
     * @return id-ul temei
     */
    public Long getIdTema() {
        return this.idTema;
    }

    /**
     * @return valoarea notei
     */
    public double getNota() {
        return this.nota;
    }

    /**
     * Modifica valoarea unei note
     *
     * @param nota - noua valoarea a notei
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * @return data in care a fost predata nota
     */
    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return idStudent + "," + idTema + "," + nota + "," + data;
    }

    /**
     * modifica id-ul studentului
     *
     * @param idStudent - noul id
     */
    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    /**
     * modifica id-ul temei
     *
     * @param idTema - noul id
     */
    public void setIdTema(Long idTema) {
        this.idTema = idTema;
    }
}
