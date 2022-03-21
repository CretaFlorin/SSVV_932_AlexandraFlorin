package curent.domain;


public class Tema extends BaseEntity<Long> {
    private String descriere;
    private int deadline;
    private int primire;

    /**
     * @param nrTema    - numarul temei
     * @param descriere - descrierea unei teme
     * @param deadline  - deadlineul unei teme
     * @param primire   - saptamana de primirea unei teme
     *                  Class Constructor
     */
    public Tema(Long nrTema, String descriere, int deadline, int primire) {
        this.setId(nrTema);
        this.descriere = descriere;
        this.deadline = deadline;
        this.primire = primire;
    }

    /**
     * @return descrierea unei teme
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * modifica descrierea unei teme
     *
     * @param descriere - noua descriere
     */
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    /**
     * @return deadlineul unei teme
     */
    public int getDeadline() {
        return deadline;
    }

    /**
     * modifica deadlineul unei note
     */
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    /**
     * @return saptamana primirii unei teme
     */
    public int getPrimire() {
        return primire;
    }

    /**
     * modifica saptamana primirii unei teme
     *
     * @param primire - noua saptamana de primire
     */
    public void setPrimire(int primire) {
        this.primire = primire;
    }

    /**
     * @return un obiect de tip Tema sub forma unui string
     */
    @Override
    public String toString() {
        return this.getId() + "," + descriere + "," + deadline + "," + primire;
    }
}
