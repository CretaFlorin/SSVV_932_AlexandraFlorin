package repository;

import curent.domain.Nota;
import validation.Validator;

import java.time.LocalDate;

public class NotaFileRepository extends AbstractFileRepository<Long, Nota> {

    /**
     * Class constructor
     * @param filename - numele fisierului
     */
    public NotaFileRepository(Validator<Nota> validator,String filename) {
        super( validator,filename);
    }

    /**
     * Extrage informatia despre nota dintr-un string
     * @param line - stringul din care ia datele notei
     * @return nota
     */
    @Override
    public Nota extractEntity(String line) {
        String[] words = line.split(",");
        String[] data = words[3].split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        return new Nota( Long.parseLong(words[0]+words[1]), Long.parseLong(words[0]), Long.parseLong(words[1]), Double.parseDouble(words[2]), date);
    }
}
