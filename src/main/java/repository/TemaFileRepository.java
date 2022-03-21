package repository;

import curent.domain.Tema;
import validation.Validator;

public class TemaFileRepository extends AbstractFileRepository<Long, Tema> {

    /**
     * Class constructor
     * @param filename - numele fisierului
     */
    public TemaFileRepository(Validator<Tema> validator,String filename){

        super(validator,filename);
    }

    /**
     * Extrage informatia despre tema dintr-un string
     * @param linie - stringul din care ia datele temei
     * @return tema
     */
    @Override
    public Tema extractEntity(String linie) {
        String[] cuvinte = linie.split(",");
        return new Tema(Long.parseLong(cuvinte[0]), cuvinte[1], Integer.parseInt(cuvinte[2]), Integer.parseInt(cuvinte[3]));
    }
}
